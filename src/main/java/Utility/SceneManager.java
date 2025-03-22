package Utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public static void loadView(Stage stage, String fxmlFilePath, String cssFilePath) throws IOException {
        Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlFilePath));
        Scene scene = new Scene(root);
        // Nhúng css
        String css = SceneManager.class.getResource(cssFilePath).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public static void loadSignInView(Stage stage) throws IOException {
        loadView(stage, "/FXML/SignInView/SignInView.fxml", "/FXML/SignInView/SignInView.css");
    }

    public static void loadSignUpView(Stage stage) throws IOException {
        loadView(stage, "/FXML/SignUpView/SignUpView.fxml", "/FXML/SignUpView/SignUpView.css");
    }


    public static void loadRoomView(Stage stage) throws IOException {
        loadView(stage, "/FXML/RoomView/RoomView.fxml", "/FXML/RoomView/RoomView.css");
    }
    public static void loadRoomEditView(Stage stage) throws IOException {
        loadView(stage, "/FXML/RoomView/RoomEditView.fxml", "/FXML/RoomView/RoomView.css");
    }

    public static void loadMemberView(Stage stage) throws IOException {
        loadView(stage, "/FXML/MemberView/MemberView.fxml", "/FXML/MemberView/MemberView.css");
    }

    public static void loadExpenditureView(Stage stage) throws IOException {
        loadView(stage, "/FXML/ExpenditureView/ExpenditureView.fxml", "/FXML/ExpenditureView/ExpenditureView.css");
    }

    public static void loadHistoryView(Stage stage) throws IOException {
        loadView(stage, "/FXML/HistoryView/HistoryView.fxml", "/FXML/HistoryView/HistoryView.css");
    }
}