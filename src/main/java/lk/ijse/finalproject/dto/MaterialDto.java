package lk.ijse.finalproject.dto;

public class MaterialDto {

    private  String material_id;
    private  String name;
    private  String color_type;
    private int quantity;

    public MaterialDto(String material_id, String name, String color_type, int quantity) {
        this.material_id = material_id;
        this.name = name;
        this.color_type = color_type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getColor_type() {
        return color_type;
    }

    public void setColor_type(String color_type) {
        this.color_type = color_type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MaterialDto{" +
                "material_id='" + material_id + '\'' +
                ", name='" + name + '\'' +
                ", color_type='" + color_type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
