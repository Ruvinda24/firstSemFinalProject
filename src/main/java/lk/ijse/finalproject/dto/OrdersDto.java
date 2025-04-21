package lk.ijse.finalproject.dto;

public class OrdersDto {

    private String order_id;
    private String order_date;
    private String customer_id;
    private String shipment_id;
    private String status;

    public OrdersDto(String order_id, String order_date,
                     String customer_id, String shipment_id, String status) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer_id = customer_id;
        this.shipment_id = shipment_id;
        this.status = status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getShipment_id() {
        return shipment_id;
    }

    public void setShipment_id(String shipment_id) {
        this.shipment_id = shipment_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "order_id='" + order_id + '\'' +
                ", order_date='" + order_date + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", shipment_id='" + shipment_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
