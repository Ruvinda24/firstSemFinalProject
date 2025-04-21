package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.InventoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryModel {

    public String saveItems(InventoryDto inventoryDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO inventory VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, inventoryDto.getInventory_id());
        statement.setString(2, inventoryDto.getItem_name());
        statement.setString(3, inventoryDto.getPrinted_embroidered());
        statement.setString(4, inventoryDto.getSize());
        statement.setDouble(5, inventoryDto.getUnit_price());
        statement.setInt(6, inventoryDto.getQuantity_available());
        statement.setString(7, inventoryDto.getStored_location());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateItems(InventoryDto inventoryDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE inventory SET item_name = ?, printed_embroidered = ?, size = ?, unit_price = ?, quantity_available = ? ,stored_location = ? WHERE inventory_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, inventoryDto.getItem_name());
        statement.setString(2, inventoryDto.getPrinted_embroidered());
        statement.setString(3, inventoryDto.getSize());
        statement.setDouble(4, inventoryDto.getUnit_price());
        statement.setInt(5, inventoryDto.getQuantity_available());
        statement.setString(6, inventoryDto.getStored_location());
        statement.setString(7, inventoryDto.getInventory_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteItems(String inventory_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM inventory WHERE inventory_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, inventory_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public InventoryDto searchItems(String inventory_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM inventory WHERE invetory_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, inventory_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            InventoryDto dto = new InventoryDto(rst.getString("inventory_id"),
                    rst.getString("item_name"), rst.getString("printed_embroidered"),
                    rst.getString("size"),rst.getDouble("unit_price"),
                    rst.getInt("quantity_available"),
                    rst.getString("stored_location")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<InventoryDto> getAllItems() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM inventory";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<InventoryDto> inventoryDto = new ArrayList<>();

        while (rst.next()) {
            InventoryDto dto = new InventoryDto(rst.getString("inventory_id"),
                    rst.getString("item_name"), rst.getString("printed_embroidered"),
                    rst.getString("size"),rst.getDouble("unit_price"),
                    rst.getInt("quantity_available"),
                    rst.getString("stored_location")
            );
            inventoryDto.add(dto);
        }
        return inventoryDto;
    }
}
