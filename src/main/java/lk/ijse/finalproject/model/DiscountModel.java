package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.DiscountDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountModel {
    public String saveDiscounts(DiscountDto discountDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO discount VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, discountDto.getDiscount_id());
        statement.setString(2, discountDto.getPayment_id());
        statement.setString(3, discountDto.getDiscount_type());
        statement.setDouble(4, discountDto.getDiscount_percentage());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateDiscounts(DiscountDto discountDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE discount SET payment_id = ?, discount_type = ?, discount_percentage = ?WHERE discount_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, discountDto.getPayment_id());
        statement.setString(2, discountDto.getDiscount_type());
        statement.setDouble(3, discountDto.getDiscount_percentage());
        statement.setString(4, discountDto.getDiscount_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteDiscounts(String discount_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM discount WHERE dicount_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, discount_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public DiscountDto searchDiscounts(String discount_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM discount WHERE dicount_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, discount_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            DiscountDto dto = new DiscountDto(rst.getString("discount_id"),
                    rst.getString("payment_id"), rst.getString("discount_type"),
                    rst.getDouble("discount_percentage")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<DiscountDto> getAllDiscounts() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM discounts";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<DiscountDto> discountDto = new ArrayList<>();

        while (rst.next()) {
            DiscountDto dto = new DiscountDto(rst.getString("discount_id"),
                    rst.getString("payment_id"), rst.getString("discount_type"),
                    rst.getDouble("discount_percentage")
            );
            discountDto.add(dto);
        }
        return discountDto;
    }
}
