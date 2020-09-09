package cnabookstore.order;

import cnabookstore.order.config.kafka.KafkaProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStatusChanged_ChangeDeliveryStatus(@Payload DeliveryStatusChanged deliveryStatusChanged){

        if(deliveryStatusChanged.isMe()){
            System.out.println("##### listener ChangeDeliveryStatus : " + deliveryStatusChanged.toJson());

            Optional<Order> orderOptional = orderRepository.findById(deliveryStatusChanged.getOrderId());
            orderOptional.ifPresent((order) ->{
                order.setOrderStatus(deliveryStatusChanged.getDeliveryStatus());
                orderRepository.save(order);
            });

        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryPrepared_ChangeDeliveryStatus(@Payload DeliveryPrepared deliveryPrepared){

        if(deliveryPrepared.isMe()){
            System.out.println("##### listener DeliveryPrepared : " + deliveryPrepared.toJson());

            Optional<Order> orderOptional = orderRepository.findById(deliveryPrepared.getOrderId());
            orderOptional.ifPresent(order -> {
                order.setOrderStatus(deliveryPrepared.getStatus());
                orderRepository.save(order);
            });

        }
    }

}
