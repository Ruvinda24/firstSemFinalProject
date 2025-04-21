module lk.ijse.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens lk.ijse.finalproject to javafx.fxml;
    exports lk.ijse.finalproject;


}