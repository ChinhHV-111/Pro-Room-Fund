package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RoomEditView {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextArea nameTextArea;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    ImageView roomImageView;

    @FXML
    public void onRoomClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/RoomView/RoomView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/RoomView/RoomView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMemberClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/MemberView/MemberView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/MemberView/MemberView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onExpenditureClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/ExpenditureView/ExpenditureView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/ExpenditureView/ExpenditureView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onHistoryClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/HistoryView/HistoryView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/HistoryView/HistoryView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onLogOutClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/SignInView/SignInView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/SignInView/SignInView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
