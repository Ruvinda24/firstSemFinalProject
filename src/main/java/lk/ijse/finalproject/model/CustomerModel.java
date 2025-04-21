package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public String saveCustomers(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO customer VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerDto.getCustomerId());
        statement.setString(2, customerDto.getCustomerName());
        statement.setString(3, customerDto.getCutomerPhone());
        statement.setString(4, customerDto.getCustomerAddress());
        statement.setString(5, customerDto.getOrderPlatForm());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateCustomers(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET name = ?, phone = ?, address = ?, order_platform = ?WHERE customer_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerDto.getCustomerName());
        statement.setString(2, customerDto.getCutomerPhone());
        statement.setString(3, customerDto.getCustomerAddress());
        statement.setString(4, customerDto.getOrderPlatForm());
        statement.setString(5, customerDto.getCustomerId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteCustomers(String customer_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public CustomerDto searchCustomers(String customer_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            CustomerDto dto = new CustomerDto(rst.getString("customer_id"),
                    rst.getString("name"), rst.getString("phone"),
                    rst.getString("address"),rst.getString("order_platform")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<CustomerDto> getAllCustomers() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<CustomerDto> customerDto = new ArrayList<>();

        while (rst.next()) {
            CustomerDto dto = new CustomerDto(rst.getString("customer_id"),
                    rst.getString("name"), rst.getString("phone"),
                    rst.getString("address"),rst.getString("order_platform")
            );
            customerDto.add(dto);
        }
        return customerDto;
    }
}
