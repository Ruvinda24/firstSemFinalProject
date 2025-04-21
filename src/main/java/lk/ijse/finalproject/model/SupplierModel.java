package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public String saveSuppliers(SupplierDto supplierDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO supplier VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplierDto.getSupplier_id());
        statement.setString(2, supplierDto.getName());
        statement.setString(3, supplierDto.getContact());
        statement.setString(4, supplierDto.getAccount_details());


        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateSuppliers(SupplierDto supplierDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE supplier SET name = ?, contact = ?, account_details = ? WHERE supplier_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, supplierDto.getName());
        statement.setString(2, supplierDto.getContact());
        statement.setString(3, supplierDto.getAccount_details());
        statement.setString(4, supplierDto.getSupplier_id());


        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteSuppliers(String supplier_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM supplier WHERE supplier_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplier_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public SupplierDto searchSuppliers(String supplier_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplier WHERE supplier_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplier_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            SupplierDto dto = new SupplierDto(rst.getString("supplier_id"),
                    rst.getString("name"), rst.getString("contact"),
                    rst.getString("account_details")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<SupplierDto> getAllSuppliers() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplier";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<SupplierDto> supplireDto = new ArrayList<>();

        while (rst.next()) {
            SupplierDto dto = new SupplierDto(rst.getString("supplier_id"),
                    rst.getString("name"), rst.getString("contact"),
                    rst.getString("account_details")
            );
            supplireDto.add(dto);
        }
        return supplireDto;
    }
}
