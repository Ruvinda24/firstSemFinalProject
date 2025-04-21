package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.ShipmentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShipmentModel {

    public String saveShipments(ShipmentDto shipmentDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO shipment VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, shipmentDto.getShipment_id());
        statement.setString(2, shipmentDto.getTracking_number());
        statement.setString(3, shipmentDto.getShipment_date());



        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateShipments(ShipmentDto shipmentDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE shipment SET tracking_number = ?, shipment_date = ? WHERE shipment_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, shipmentDto.getTracking_number());
        statement.setString(2, shipmentDto.getShipment_date());
        statement.setString(3, shipmentDto.getShipment_id());


        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteShipments(String material_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM shipment WHERE shipment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, material_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public ShipmentDto searchShipments(String shipment_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM shipment WHERE shipment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, shipment_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            ShipmentDto dto = new ShipmentDto(rst.getString("shipment_id"),
                    rst.getString("tracking_number"), rst.getString("shipment_date")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<ShipmentDto> getAllShipments() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM shipment";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<ShipmentDto> shipmentDto = new ArrayList<>();

        while (rst.next()) {
            ShipmentDto dto = new ShipmentDto(rst.getString("shipment_id"),
                    rst.getString("tracking_number"), rst.getString("shipment_date")
            );
            shipmentDto.add(dto);
        }
        return shipmentDto;
    }
}
