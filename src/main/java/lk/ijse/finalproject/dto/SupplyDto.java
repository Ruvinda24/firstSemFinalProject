package lk.ijse.finalproject.dto;

public class SupplyDto {

    private String supply_id;
    private String supplier_id;
    private String material_id;
    private double amount;
    private int quantity;

    public SupplyDto(String supply_id, String supplier_id, String material_id, double amount, int quantity) {
        this.supply_id = supply_id;
        this.supplier_id = supplier_id;
        this.material_id = material_id;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(String supply_id) {
        this.supply_id = supply_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SupplyDto{" +
                "supply_id='" + supply_id + '\'' +
                ", supplier_id='" + supplier_id + '\'' +
                ", material_id='" + material_id + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
