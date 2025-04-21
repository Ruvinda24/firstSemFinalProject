package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.MaterialDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialModel {

    public String saveMaterials(MaterialDto materialDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO material VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, materialDto.getMaterial_id());
        statement.setString(2, materialDto.getName());
        statement.setString(3, materialDto.getColor_type());
        statement.setInt(4, materialDto.getQuantity());


        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateMaterials(MaterialDto materialDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE material SET name = ?, color_type = ?, quantity = ? WHERE material_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, materialDto.getName());
        statement.setString(2, materialDto.getColor_type());
        statement.setInt(3, materialDto.getQuantity());
        statement.setString(4, materialDto.getMaterial_id());


        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteMaterials(String material_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM material WHERE material_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, material_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public MaterialDto searchMaterials(String material_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM material WHERE material_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, material_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            MaterialDto dto = new MaterialDto(rst.getString("material_id"),
                    rst.getString("name"), rst.getString("color_type"),
                    rst.getInt("address")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<MaterialDto> getAllMaterials() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM material";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<MaterialDto> materialDto = new ArrayList<>();

        while (rst.next()) {
            MaterialDto dto = new MaterialDto(rst.getString("material_id"),
                    rst.getString("name"), rst.getString("color_type"),
                    rst.getInt("address")
            );
            materialDto.add(dto);
        }
        return materialDto;
    }
}
