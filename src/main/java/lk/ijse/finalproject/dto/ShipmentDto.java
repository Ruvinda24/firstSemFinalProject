package lk.ijse.finalproject.dto;

public class ShipmentDto {

    private String shipment_id;
    private String tracking_number;
    private String shipment_date;

    public ShipmentDto(String shipment_id, String tracking_number, String shipment_date) {
        this.shipment_id = shipment_id;
        this.tracking_number = tracking_number;
        this.shipment_date = shipment_date;
    }

    public String getShipment_id() {
        return shipment_id;
    }

    public void setShipment_id(String shipment_id) {
        this.shipment_id = shipment_id;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }

    @Override
    public String toString() {
        return "ShipmentDto{" +
                "shipment_id='" + shipment_id + '\'' +
                ", tracking_number='" + tracking_number + '\'' +
                ", shipment_date='" + shipment_date + '\'' +
                '}';
    }
}
