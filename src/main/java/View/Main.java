package View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load file fxml ban đầu và truyền vào scene
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignInView/SignInView.fxml"));
        Scene scene = new Scene(root);

        // Nhúng css
        String css = getClass().getResource("/FXML/SignInView/SignInView.css").toExternalForm();
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
