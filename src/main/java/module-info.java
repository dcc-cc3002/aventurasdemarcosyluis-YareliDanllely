module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens characters to javafx.fxml;
    exports characters;
    exports characters.maincharacter.interfaces;
    opens characters.maincharacter.interfaces to javafx.fxml;
    exports characters.enemies;
    opens characters.enemies to javafx.fxml;
    exports characters.maincharacter;
    opens characters.maincharacter to javafx.fxml;
    exports characters.enemies.interfaces;
    opens characters.enemies.interfaces to javafx.fxml;
}