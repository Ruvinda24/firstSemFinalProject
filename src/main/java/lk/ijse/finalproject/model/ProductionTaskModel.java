package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.ProductionTaskDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductionTaskModel {
    public String saveProductionTasks(ProductionTaskDto productionTaskDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO production_task VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, productionTaskDto.getProduction_task_id());
        statement.setString(2, productionTaskDto.getProduction_id());
        statement.setString(3, productionTaskDto.getTask_id());


        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateProductionTasks(ProductionTaskDto productionTaskDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE production_task SET production_id = ?, task_id = ?WHERE production_task_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, productionTaskDto.getProduction_id());
        statement.setString(2, productionTaskDto.getTask_id());
        statement.setString(3, productionTaskDto.getProduction_task_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteProductionTasks(String production_task_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM production_task WHERE production_task_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, production_task_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public ProductionTaskDto searchProductionTasks(String production_task_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM production_task WHERE production_task_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, production_task_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            ProductionTaskDto dto = new ProductionTaskDto(rst.getString("production_task_id"),
                    rst.getString("production_id"), rst.getString("task_id")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<ProductionTaskDto> getAllProductionTasks() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM production_task";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<ProductionTaskDto> productionTaskDto = new ArrayList<>();

        while (rst.next()) {
            ProductionTaskDto dto = new ProductionTaskDto(rst.getString("production_task_id"),
                    rst.getString("production_id"), rst.getString("task_id")
            );
            productionTaskDto.add(dto);
        }
        return productionTaskDto;
    }
}
