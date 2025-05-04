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
import lk.ijse.finalProject.dto.UserDto;
import lk.ijse.finalProject.model.UserModel;
import lk.ijse.finalProject.util.CrudUtil;

import java.sql.ResultSet;

public class SignUpPageController {


    public TextField signupNameField;
    public TextField signupEmailField;
    public TextField signupNumberField;
    public TextField signupUserNameField;
    public PasswordField signupPasswordField;
    public PasswordField signupReEnterPasswordField;

    public void btnGoBackToLoginOnAction(ActionEvent actionEvent) {
        try {
            Parent dashBoardRoot = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
            Stage dashBoardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            dashBoardStage.setScene(new Scene(dashBoardRoot));
            dashBoardStage.setTitle("Dream Baby Care Products");
            dashBoardStage.setResizable(true);
            dashBoardStage.show();
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load to Login page").show();
        }
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        String inputName = signupNameField.getText();
        String inputEmail = signupEmailField.getText();
        String inputNumber = signupNumberField.getText();
        String inputUserName = signupUserNameField.getText();
        String inputPassword = signupPasswordField.getText();
        String inputReEnterPassword = signupReEnterPasswordField.getText();

        //validate empty fields
        if(inputName.isEmpty() || inputEmail.isEmpty() || inputNumber.isEmpty() || inputUserName.isEmpty() || inputPassword.isEmpty() || inputReEnterPassword.isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
            return;
        }

        // Validate email format
        if (!inputEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid email format").show();
            return;
        }

        // Validate phone number format (example: 10 digits)
        if (!inputNumber.matches("\\d{10}")) {
            new Alert(Alert.AlertType.ERROR, "Invalid phone number. It should contain 10 digits").show();
            return;
        }

        // Validate password strength (example: at least 8 characters, 1 uppercase, 1 lowercase, 1 digit)
        if (!inputPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            new Alert(Alert.AlertType.ERROR, "Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, and a digit").show();
            return;
        }

        if(!inputPassword.equals(inputReEnterPassword)){
            new Alert(Alert.AlertType.ERROR, "Passwords do not match").show();
            return;
        }

        // Check for duplicate username or email in the database
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM user WHERE user_name = ? OR email = ?", inputUserName, inputEmail);
            if (resultSet.next()) {
                new Alert(Alert.AlertType.ERROR, "Username or email already exists").show();
                return;
            }

        // Here you would typically save the user data to a database or other data source
            UserModel.saveUsers(
                    new UserDto(
                            UserModel.getNextUserId(),
                            inputUserName,
                            inputPassword,
                            inputEmail,
                            inputName,
                            inputNumber
                    )
            );
            // Show success message
            new Alert(Alert.AlertType.INFORMATION, "Sign up successful!").show();
            btnGoBackToLoginOnAction(actionEvent);
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Sign up failed. Database Connection Error").show();
        }
    }
}
