package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {

    public String savePayments(PaymentDto paymentDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO payment VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, paymentDto.getPayment_id());
        statement.setString(2, paymentDto.getOrder_id());
        statement.setDouble(3, paymentDto.getAmount());
        statement.setString(4, paymentDto.getPayment_method());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updatePayments(PaymentDto paymentDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE payment SET order_id = ?, amount = ?, payment_method = ?WHERE payment_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, paymentDto.getOrder_id());
        statement.setDouble(2, paymentDto.getAmount());
        statement.setString(3, paymentDto.getPayment_method());
        statement.setString(4, paymentDto.getPayment_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deletePayments(String payment_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM payment WHERE payment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, payment_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public PaymentDto searchPayments(String payment_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, payment_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            PaymentDto dto = new PaymentDto(rst.getString("payment_id"),
                    rst.getString("order_id"), rst.getDouble("amount"),
                    rst.getString("payment_method")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<PaymentDto> getAllPayments() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM payment";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<PaymentDto> paymentDto = new ArrayList<>();

        while (rst.next()) {
            PaymentDto dto = new PaymentDto(rst.getString("payment_id"),
                    rst.getString("order_id"), rst.getDouble("amount"),
                    rst.getString("payment_method")
            );
            paymentDto.add(dto);
        }
        return paymentDto;
    }
}
