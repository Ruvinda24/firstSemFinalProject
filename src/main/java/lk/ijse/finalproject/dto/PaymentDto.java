package lk.ijse.finalproject.dto;

public class PaymentDto {

    private String payment_id;
    private String order_id;
    private double amount;
    private String payment_method;

    public PaymentDto(String payment_id, String order_id, double amount, String payment_method) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.amount = amount;
        this.payment_method = payment_method;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "payment_id='" + payment_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", amount=" + amount +
                ", payment_method='" + payment_method + '\'' +
                '}';
    }
}
