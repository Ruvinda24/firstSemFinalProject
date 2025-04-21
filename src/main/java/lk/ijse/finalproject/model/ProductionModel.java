package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.ProductionDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductionModel {


    public String saveProductions(ProductionDto productionDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO production VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, productionDto.getProduction_id());
        statement.setString(2, productionDto.getInventory_id());
        statement.setString(3, productionDto.getDescription());
        statement.setString(4, productionDto.getStatus());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateProductions(ProductionDto productionDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE production SET inventory_id = ?, description = ?, status = ?WHERE production_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, productionDto.getInventory_id());
        statement.setString(2, productionDto.getDescription());
        statement.setString(3, productionDto.getStatus());
        statement.setString(4, productionDto.getProduction_id());
        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteProductions(String production_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM production WHERE production_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, production_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public ProductionDto searchProductions(String production_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM production WHERE production_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, production_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            ProductionDto dto = new ProductionDto(rst.getString("production_id"),
                    rst.getString("inventory_id"), rst.getString("description"),
                    rst.getString("status")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<ProductionDto> getAllProductions() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM production";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<ProductionDto> productionDto = new ArrayList<>();

        while (rst.next()) {
            ProductionDto dto = new ProductionDto(rst.getString("production_id"),
                    rst.getString("inventory_id"), rst.getString("description"),
                    rst.getString("status")
            );
            productionDto.add(dto);
        }
        return productionDto;
    }
}
