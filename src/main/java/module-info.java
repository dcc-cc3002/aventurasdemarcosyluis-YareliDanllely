module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens character to javafx.fxml;
    exports character;
    exports interfaces;
    opens interfaces to javafx.fxml;
}