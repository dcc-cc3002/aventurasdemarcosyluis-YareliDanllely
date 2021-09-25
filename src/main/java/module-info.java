module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens character.cc3002 to javafx.fxml;
    exports character.cc3002;
}