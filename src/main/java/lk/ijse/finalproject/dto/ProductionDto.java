package lk.ijse.finalproject.dto;

public class ProductionDto {

    private String production_id;
    private String inventory_id;
    private String description;
    private String status;

    public ProductionDto(
            String production_id, String inventory_id,
            String description, String status
    ) {
        this.production_id = production_id;
        this.inventory_id = inventory_id;
        this.description = description;
        this.status = status;
    }

    public String getProduction_id() {
        return production_id;
    }

    public void setProduction_id(String production_id) {
        this.production_id = production_id;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductionDto{" +
                "production_id='" + production_id + '\'' +
                ", inventory_id='" + inventory_id + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
