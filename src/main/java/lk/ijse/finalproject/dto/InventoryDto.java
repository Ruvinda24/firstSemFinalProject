package lk.ijse.finalproject.dto;

public class InventoryDto {

    private String inventory_id;
    private String item_name;
    private String printed_embroidered;
    private String size;
    private double unit_price;
    private int quantity_available;
    private String stored_location;

    public InventoryDto(String inventory_id, String item_name,
                        String printed_embroidered, String size,
                        double price, int quantity_available, String stored_location) {

        this.inventory_id = inventory_id;
        this.item_name = item_name;
        this.printed_embroidered = printed_embroidered;
        this.size = size;
        this.unit_price = unit_price;
        this.quantity_available = quantity_available;
        this.stored_location = stored_location;

    }
    public String getInventory_id() {
        return inventory_id;
    }
    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getPrinted_embroidered() {
        return printed_embroidered;
    }
    public void setPrinted_embroidered(String printed_embroidered) {
        this.printed_embroidered = printed_embroidered;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public double getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    public int getQuantity_available() {
        return quantity_available;
    }
    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }
    public String getStored_location() {
        return stored_location;
    }
    public void setStored_location(String stored_location) {
        this.stored_location = stored_location;
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "inventory_id='" + inventory_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", printed_embroidered='" + printed_embroidered + '\'' +
                ", size='" + size + '\'' +
                ", unit_price=" + unit_price +
                ", quantity_available=" + quantity_available +
                ", stored_location='" + stored_location + '\'' +
                '}';
    }
}
