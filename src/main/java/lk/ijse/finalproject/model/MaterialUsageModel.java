package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.MaterialUsageDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialUsageModel {
    public String saveMaterialUsage(MaterialUsageDto materialUsageDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO material_usage VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, materialUsageDto.getUsage_id());
        statement.setString(2, materialUsageDto.getProduction_id());
        statement.setString(3, materialUsageDto.getMaterial_id());
        statement.setInt(4, materialUsageDto.getQuantity_used());


        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateMaterialUsage(MaterialUsageDto materialUsageDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE material_usage SET production_id = ?, material_id = ?, quantity_used = ?WHERE usage_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, materialUsageDto.getProduction_id());
        statement.setString(2, materialUsageDto.getMaterial_id());
        statement.setInt(3, materialUsageDto.getQuantity_used());
        statement.setString(4, materialUsageDto.getUsage_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteMaterialUsage(String usage_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM material_usage WHERE usage_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usage_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public MaterialUsageDto searchMaterialUsage(String usage_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM material_usage WHERE usage_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usage_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            MaterialUsageDto dto = new MaterialUsageDto(rst.getString("usage_id"),
                    rst.getString("production_id"), rst.getString("material_id"),
                    rst.getInt("quantity_used")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<MaterialUsageDto> getAllMaterialUsage() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM material_usage";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<MaterialUsageDto> materialUsageDto = new ArrayList<>();

        while (rst.next()) {
            MaterialUsageDto dto = new MaterialUsageDto(rst.getString("usage_id"),
                    rst.getString("production_id"), rst.getString("material_id"),
                    rst.getInt("quantity_used")
            );
            materialUsageDto.add(dto);
        }
        return materialUsageDto;
    }
}
