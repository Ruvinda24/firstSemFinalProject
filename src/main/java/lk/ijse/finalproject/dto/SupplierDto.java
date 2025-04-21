package lk.ijse.finalproject.dto;

public class SupplierDto {

    private String supplier_id;
    private String name;
    private String contact;
    private String account_details;

    public SupplierDto(String supplier_id, String name, String contact, String account_details) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.contact = contact;
        this.account_details = account_details;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAccount_details() {
        return account_details;
    }

    public void setAccount_details(String account_details) {
        this.account_details = account_details;
    }

    @Override
    public String toString() {
        return "SupplierDto{" +
                "supplier_id='" + supplier_id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", account_details='" + account_details + '\'' +
                '}';
    }
}
