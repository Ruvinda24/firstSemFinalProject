package lk.ijse.finalproject.model;

import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.TaskDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskModel {


    public String saveTasks(TaskDto taskDto) throws ClassNotFoundException, SQLException {
        Connection connection = (Connection) DBConnection.getInstance().getConnection();
        String sql ="INSERT INTO task VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, taskDto.getTask_id());
        statement.setString(2, taskDto.getEmployee_id());
        statement.setString(3, taskDto.getDescription());
        statement.setString(4, taskDto.getStatus());


        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateTasks(TaskDto taskDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE task SET employee_id = ?, description = ?, status = ?WHERE task_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, taskDto.getEmployee_id());
        statement.setString(2, taskDto.getDescription());
        statement.setString(3, taskDto.getStatus());
        statement.setString(4, taskDto.getTask_id());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteTasks(String task_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM task WHERE task_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, task_id);

        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    public TaskDto searchTasks(String task_id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM task WHERE task_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, task_id);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            TaskDto dto = new TaskDto(rst.getString("task_id"),
                    rst.getString("employee_id"), rst.getString("description"),
                    rst.getString("status")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<TaskDto> getAllTasks() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM task";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<TaskDto> taskDto = new ArrayList<>();

        while (rst.next()) {
            TaskDto dto = new TaskDto(rst.getString("task_id"),
                    rst.getString("employee_id"), rst.getString("description"),
                    rst.getString("status")
            );
            taskDto.add(dto);
        }
        return taskDto;
    }
}
