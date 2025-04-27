module lk.ijse.finalProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    opens lk.ijse.finalProject to javafx.fxml;
    exports lk.ijse.finalProject;


}