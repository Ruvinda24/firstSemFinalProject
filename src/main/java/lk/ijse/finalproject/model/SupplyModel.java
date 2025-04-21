package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.SupplyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplyModel {
    public String saveSupply(SupplyDto supplyDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO supply VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplyDto.getSupply_id());
        statement.setString(2, supplyDto.getSupplier_id());
        statement.setString(3, supplyDto.getMaterial_id());
        statement.setDouble(4, supplyDto.getAmount());
        statement.setInt(5, supplyDto.getQuantity());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateSupply(SupplyDto supplyDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE supply SET supplier_id = ?, material_id = ?, amount = ?, quantity = ?WHERE supply_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplyDto.getSupplier_id());
        statement.setString(2, supplyDto.getMaterial_id());
        statement.setDouble(3, supplyDto.getAmount());
        statement.setInt(4, supplyDto.getQuantity());
        statement.setString(5, supplyDto.getSupply_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteSupply(String supply_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM supply WHERE supply_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supply_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public SupplyDto searchSupply(String supply_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supply WHERE supply_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supply_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            SupplyDto dto = new SupplyDto(rst.getString("supply_id"),
                    rst.getString("supplier_id"), rst.getString("material_id"),
                    rst.getDouble("amount"),rst.getInt("quantity")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<SupplyDto> getAllSupply() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<SupplyDto> supplyDto = new ArrayList<>();

        while (rst.next()) {
            SupplyDto dto = new SupplyDto(rst.getString("supply_id"),
                    rst.getString("supplier_id"), rst.getString("material_id"),
                    rst.getDouble("amount"),rst.getInt("quantity")
            );
            supplyDto.add(dto);
        }
        return supplyDto;
    }
}
