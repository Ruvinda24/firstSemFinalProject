package lk.ijse.finalproject.dto;

public class OrderItemDto {

    private String order_item_id;
    private String order_id;
    private String inventory_id;
    private int quantity;
    private double amount;

    public OrderItemDto(String order_item_id, String order_id,
                        String inventory_id, int quantity, double amount) {
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.inventory_id = inventory_id;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "order_item_id='" + order_item_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", inventory_id='" + inventory_id + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

}
