package lk.ijse.finalproject.dto;

public class DiscountDto {

    private  String discount_id;
    private  String payment_id;
    private  String discount_type;
    private  double discount_percentage;

    public DiscountDto(String discount_id, String payment_id, String discount_type, double discount_percentage) {
        this.discount_id = discount_id;
        this.payment_id = payment_id;
        this.discount_type = discount_type;
        this.discount_percentage = discount_percentage;
    }

    public String getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(String discount_id) {
        this.discount_id = discount_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public double getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(double discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    @Override
    public String toString() {
        return "DiscountDto{" +
                "discount_id='" + discount_id + '\'' +
                ", payment_id='" + payment_id + '\'' +
                ", discount_type='" + discount_type + '\'' +
                ", discount_percentage=" + discount_percentage +
                '}';
    }

}
