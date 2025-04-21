package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.OrderItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderItemModel {

    public String saveOrderItems(OrderItemDto orderItemDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO order_item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, orderItemDto.getOrder_item_id());
        statement.setString(2, orderItemDto.getOrder_id());
        statement.setString(3, orderItemDto.getInventory_id());
        statement.setInt(4, orderItemDto.getQuantity());
        statement.setDouble(5, orderItemDto.getAmount());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateOrderItems(OrderItemDto orderItemDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE order_item SET order_id = ?, inventory_id = ?, quantity = ?, amount = ?WHERE order_item_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, orderItemDto.getOrder_id());
        statement.setString(2, orderItemDto.getInventory_id());
        statement.setInt(3, orderItemDto.getQuantity());
        statement.setDouble(4, orderItemDto.getAmount());
        statement.setString(5, orderItemDto.getOrder_item_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteOrderItems(String order_item_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM order_item WHERE order_item_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, order_item_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public OrderItemDto searchOrderItems(String order_item_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM order_item WHERE order_item_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, order_item_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            OrderItemDto dto = new OrderItemDto(rst.getString("order_item_id"),
                    rst.getString("order_id"), rst.getString("inventory_id"),
                    rst.getInt("quantity"),rst.getDouble("amount")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<OrderItemDto> getAllOrderItems() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM order_item";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<OrderItemDto> orderItemDto = new ArrayList<>();

        while (rst.next()) {
            OrderItemDto dto = new OrderItemDto(rst.getString("order_item_id"),
                    rst.getString("order_id"), rst.getString("inventory_id"),
                    rst.getInt("quantity"),rst.getDouble("amount")
            );
            orderItemDto.add(dto);
        }
        return orderItemDto;
    }
}
