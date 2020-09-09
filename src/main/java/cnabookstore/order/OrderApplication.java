package cnabookstore.order;
import cnabookstore.order.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class OrderApplication {
    protected static ApplicationContext applicationContext;

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(OrderApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        applicationContext = application.run(args);
        //applicationContext = SpringApplication.run(OrderApplication.class, args);
    }
    public static ApplicationContext getContext(){
        return applicationContext;
    }
}
