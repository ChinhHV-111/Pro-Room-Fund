package Utility;

import View.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static FXMLLoader roomViewLoader = null;
    private static Scene roomViewScene = null;
    private static RoomView roomView = null;

    private static FXMLLoader roomEditViewLoader = null;
    private static Scene roomEditViewScene = null;
    private static RoomEditView roomEditView = null;

    private static FXMLLoader memberViewLoader = null;
    private static Scene memberViewScene = null;
    private static MemberView memberView = null;

    private static FXMLLoader expenditureViewLoader = null;
    private static Scene expenditureViewScene = null;
    private static ExpenditureView expenditureView = null;

    private static FXMLLoader historyViewLoader = null;
    private static Scene historyViewScene = null;
    private static HistoryView historyView = null;

    public static void loadStage(Stage stage, String fxmlFilePath, String cssFilePath) throws IOException {
        // Load file fxml ban đầu và truyền vào scene
        Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlFilePath));
        Scene scene = new Scene(root);

        // Nhúng css
        String css = SceneManager.class.getResource(cssFilePath).toExternalForm();
        scene.getStylesheets().add(css);

        // Đổi icon góc trên bên trái
        Image icon = new Image(SceneManager.class.getResource("/Images/Logo.png").toExternalForm());
        stage.getIcons().add(icon);

        // Set title stage, scene
        stage.setTitle("ProRoomFund");
        stage.setScene(scene);

        // Show
        stage.show();
    }

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

    // Phải luôn dùng getScene trước khi dùng getController
    public static Scene getRoomViewScene() throws IOException {
        if (roomViewScene == null) {
            roomViewLoader = new FXMLLoader(SceneManager.class.getResource("/FXML/RoomView/RoomView.fxml"));
            roomViewScene = new Scene(roomViewLoader.load());
            roomView = roomViewLoader.getController();
            // Nhúng css
            String css = SceneManager.class.getResource("/FXML/RoomView/RoomView.css").toExternalForm();
            roomViewScene.getStylesheets().add(css);
        }
        return roomViewScene;
    }
    public static RoomView getRoomView() {
        return roomView;
    }

    public static Scene getRoomEditViewScene() throws IOException {
        if (roomEditViewScene == null) {
            roomEditViewLoader = new FXMLLoader(SceneManager.class.getResource("/FXML/RoomView/RoomEditView.fxml"));
            roomEditViewScene = new Scene(roomEditViewLoader.load());
            roomEditView = roomEditViewLoader.getController();
            // Nhúng css
            String css = SceneManager.class.getResource("/FXML/RoomView/RoomView.css").toExternalForm();
            roomEditViewScene.getStylesheets().add(css);
        }
        return roomEditViewScene;
    }
    public static RoomEditView getRoomEditView() {
        return roomEditView;
    }

    public static Scene getMemberViewScene() throws IOException {
        if (memberViewScene == null) {
            memberViewLoader = new FXMLLoader(SceneManager.class.getResource("/FXML/MemberView/MemberView.fxml"));
            memberViewScene = new Scene(memberViewLoader.load());
            memberView = memberViewLoader.getController();
            // Nhúng css
            String css = SceneManager.class.getResource("/FXML/MemberView/MemberView.css").toExternalForm();
            memberViewScene.getStylesheets().add(css);
        }
        return memberViewScene;
    }
    public static MemberView getMemberView() {
        return memberView;
    }

    public static Scene getExpenditureViewScene() throws IOException {
        if (expenditureViewScene == null) {
            expenditureViewLoader = new FXMLLoader(SceneManager.class.getResource("/FXML/ExpenditureView/ExpenditureView.fxml"));
            expenditureViewScene = new Scene(expenditureViewLoader.load());
            expenditureView = expenditureViewLoader.getController();
            // Nhúng css
            String css = SceneManager.class.getResource("/FXML/ExpenditureView/ExpenditureView.css").toExternalForm();
            expenditureViewScene.getStylesheets().add(css);
        }
        return expenditureViewScene;
    }
    public static ExpenditureView getExpenditureView() {
        return expenditureView;
    }

    public static Scene getHistoryViewScene() throws IOException {
        if (historyViewScene == null) {
            historyViewLoader = new FXMLLoader(SceneManager.class.getResource("/FXML/HistoryView/HistoryView.fxml"));
            historyViewScene = new Scene(historyViewLoader.load());
            historyView = historyViewLoader.getController();
            // Nhúng css
            String css = SceneManager.class.getResource("/FXML/HistoryView/HistoryView.css").toExternalForm();
            historyViewScene.getStylesheets().add(css);
        }
        return historyViewScene;
    }
    public static HistoryView getHistoryView() {
        return historyView;
    }
}