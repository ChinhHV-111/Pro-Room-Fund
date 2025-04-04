package View;
import Utility.SceneManager;
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
        SceneManager.loadStage(primaryStage, "/FXML/SignInView/SignInView.fxml", "/FXML/SignInView/SignInView.css");
    }
}
