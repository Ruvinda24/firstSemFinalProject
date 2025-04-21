package lk.ijse.finalproject.dto;

public class MaterialUsageDto {

    private String usage_id;
    private String production_id;
    private String material_id;
    private int quantity_used;

    public MaterialUsageDto(String usage_id, String production_id, String material_id, int quantity_used) {
        this.usage_id = usage_id;
        this.production_id = production_id;
        this.material_id = material_id;
        this.quantity_used = quantity_used;
    }

    public String getUsage_id() {
        return usage_id;
    }

    public void setUsage_id(String usage_id) {
        this.usage_id = usage_id;
    }

    public String getProduction_id() {
        return production_id;
    }

    public void setProduction_id(String production_id) {
        this.production_id = production_id;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public int getQuantity_used() {
        return quantity_used;
    }

    public void setQuantity_used(int quantity_used) {
        this.quantity_used = quantity_used;
    }

    @Override
    public String toString() {
        return "MaterialUsageDto{" +
                "usage_id='" + usage_id + '\'' +
                ", production_id='" + production_id + '\'' +
                ", material_id='" + material_id + '\'' +
                ", quantity_used=" + quantity_used +
                '}';
    }

}
