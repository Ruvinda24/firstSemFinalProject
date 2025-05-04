package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalProject.util.CrudUtil;

import java.sql.ResultSet;

public class LoginController {

    public TextField userNameField;
    public PasswordField passwordField;


    public void visitDashboardOnAction(ActionEvent actionEvent) {
        String inputUserName = userNameField.getText();
        String inputPassword = passwordField.getText();
        // Here you would typically check the credentials against a database or other data source

        if(inputUserName.isEmpty() || inputPassword.isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Please enter username and password").show();
            return;
        }

        try{
            ResultSet resultSet = CrudUtil.execute(
                    "SELECT * FROM user WHERE user_name = ? AND password = ?",
                    inputUserName, inputPassword);
            if(resultSet.next()){
                try {
                    Parent dashBoardRoot = FXMLLoader.load(getClass().getResource("/view/DashBoardView.fxml"));
                    Stage dashBoardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    dashBoardStage.setScene(new Scene(dashBoardRoot));
                    dashBoardStage.setTitle("Dream Baby Care Products");
                    dashBoardStage.setResizable(true);
                    dashBoardStage.show();
                }catch (Exception e){
                    e.printStackTrace();
                    new Alert(Alert.AlertType.ERROR, "Failed to load to dash board").show();
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
            }

        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Login failed. Database Connection Error").show();

        }
    }

    public void visitSignUpPageOnAction(ActionEvent actionEvent) {
        try {
            Parent dashBoardRoot = FXMLLoader.load(getClass().getResource("/view/SignUpView.fxml"));
            Stage dashBoardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            dashBoardStage.setScene(new Scene(dashBoardRoot));
            dashBoardStage.setTitle("Dream Baby Care Products");
            dashBoardStage.setResizable(true);
            dashBoardStage.show();
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load to SignUp page").show();
        }
    }
}
