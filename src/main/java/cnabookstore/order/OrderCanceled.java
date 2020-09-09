
package cnabookstore.order;

import cnabookstore.order.event.AbstractEvent;

public class OrderCanceled extends AbstractEvent {

    private Long orderId;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


}
