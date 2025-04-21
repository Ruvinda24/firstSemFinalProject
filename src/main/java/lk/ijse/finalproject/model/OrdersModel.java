package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.OrdersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersModel {
    public String saveOrders(OrdersDto orderDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO orders VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, orderDto.getOrder_id());
        statement.setString(2, orderDto.getOrder_date());
        statement.setString(3, orderDto.getCustomer_id());
        statement.setString(4, orderDto.getShipment_id());
        statement.setString(5, orderDto.getStatus());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateOrders(OrdersDto orderDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE orders SET order_date = ?, customer_id = ?, shipment_id = ?, status = ?WHERE order_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, orderDto.getOrder_date());
        statement.setString(2, orderDto.getCustomer_id());
        statement.setString(3, orderDto.getShipment_id());
        statement.setString(4, orderDto.getStatus());
        statement.setString(5, orderDto.getOrder_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteOrders(String order_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM orders WHERE order_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, order_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public OrdersDto searchOrders(String order_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, order_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            OrdersDto dto = new OrdersDto(rst.getString("order_id"),
                    rst.getString("order_date"), rst.getString("customer_id"),
                    rst.getString("shipment_id"),rst.getString("status")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<OrdersDto> getAllOrders() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM orders";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<OrdersDto> orderDto = new ArrayList<>();

        while (rst.next()) {
            OrdersDto dto = new OrdersDto(rst.getString("order_id"),
                    rst.getString("order_date"), rst.getString("customer_id"),
                    rst.getString("shipment_id"),rst.getString("status")
            );
            orderDto.add(dto);
        }
        return orderDto;
    }
}
