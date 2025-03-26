module com.example.prohomefund {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens View to javafx.fxml;
    exports View;

    opens Model to javafx.base;
}