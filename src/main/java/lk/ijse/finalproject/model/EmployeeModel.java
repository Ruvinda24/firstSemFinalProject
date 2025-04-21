package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public String saveEmployees(EmployeeDto employeeDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO employee VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, employeeDto.getEmployee_id());
        statement.setString(2, employeeDto.getName());
        statement.setString(3, employeeDto.getNic());
        statement.setString(4, employeeDto.getNumber());
        statement.setString(5, employeeDto.getRole());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateEmployees(EmployeeDto employeeDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE employee SET name = ?, nic = ?, number = ?, role = ? WHERE employee_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, employeeDto.getName());
        statement.setString(2, employeeDto.getNic());
        statement.setString(3, employeeDto.getNumber());
        statement.setString(4, employeeDto.getRole());
        statement.setString(5, employeeDto.getEmployee_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteEmployees(String employee_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public EmployeeDto searchEmployees(String employee_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            EmployeeDto dto = new EmployeeDto(rst.getString("employee_id"),
                    rst.getString("name"), rst.getString("nic"),
                    rst.getString("number"),rst.getString("role")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<EmployeeDto> getAllEmployees() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<EmployeeDto> employeeDto = new ArrayList<>();

        while (rst.next()) {
            EmployeeDto dto = new EmployeeDto(rst.getString("employee_id"),
                    rst.getString("name"), rst.getString("nic"),
                    rst.getString("number"),rst.getString("role")
            );
            employeeDto.add(dto);
        }
        return employeeDto;
    }


}
