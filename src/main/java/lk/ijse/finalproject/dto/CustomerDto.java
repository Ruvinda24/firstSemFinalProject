package lk.ijse.finalproject.dto;

public class CustomerDto {
    private String customerId;
    private String customerName;
    private String cutomerPhone;
    private String customerAddress;
    private String orderPlatForm;

    public CustomerDto(String customerId, String customerName, String cutomerPhone, String customerAddress, String orderPlatForm) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cutomerPhone = cutomerPhone;
        this.customerAddress = customerAddress;
        this.orderPlatForm = orderPlatForm;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCutomerPhone() {
        return cutomerPhone;
    }
    public void setCutomerPhone(String cutomerPhone) {
        this.cutomerPhone = cutomerPhone;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getOrderPlatForm() {
        return orderPlatForm;
    }
    public void setOrderPlatForm(String orderPlatForm) {
        this.orderPlatForm = orderPlatForm;
    }


    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", cutomerPhone='" + cutomerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", orderPlatForm='" + orderPlatForm + '\'' +
                '}';
    }
}
