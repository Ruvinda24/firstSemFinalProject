package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {

    public String saveUsers(UserDto userDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO user VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, userDto.getUser_id());
        statement.setString(2, userDto.getUser_name());
        statement.setString(3, userDto.getPassword());
        statement.setString(4, userDto.getEmail());
        statement.setString(5, userDto.getName());
        statement.setString(6, userDto.getPhone_number());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateUsers(UserDto userDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE user SET user_name = ?, password = ?, email = ?, name = ?, phone_number = ?WHERE user_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, userDto.getUser_name());
        statement.setString(2, userDto.getPassword());
        statement.setString(3, userDto.getEmail());
        statement.setString(4, userDto.getName());
        statement.setString(5, userDto.getPhone_number());
        statement.setString(6, userDto.getUser_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteUsers(String user_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM user WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public UserDto searchUsers(String user_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            UserDto dto = new UserDto(rst.getString("user_id"),
                    rst.getString("user_name"), rst.getString("password"),
                    rst.getString("email"),rst.getString("name"),
                    rst.getString("phone_number")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<UserDto> getAllUsers() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<UserDto> userDto = new ArrayList<>();

        while (rst.next()) {
            UserDto dto = new UserDto(rst.getString("user_id"),
                    rst.getString("user_name"), rst.getString("password"),
                    rst.getString("email"),rst.getString("name"),
                    rst.getString("phone_number")
            );
            userDto.add(dto);
        }
        return userDto;
    }
}
