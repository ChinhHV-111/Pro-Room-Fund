package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GroupView/GroupView.fxml"));
        Scene scene = new Scene(root);

        // Nhúng css
        String css = getClass().getResource("/GroupView/GroupView.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Đổi icon góc trên bên trái
        Image icon = new Image(getClass().getResource("/Images/Logo.png").toExternalForm());
        primaryStage.getIcons().add(icon);

        // Set title stage, scene
        primaryStage.setTitle("ProHomeFund");
        primaryStage.setScene(scene);

        // Show
        primaryStage.show();
    }
}
