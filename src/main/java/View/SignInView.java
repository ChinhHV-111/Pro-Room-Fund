package View;

import Utility.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInView {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label invalidSignInLabel;

    @FXML
    public void onSignUpClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        SceneManager.loadSignUpView(stage);
    }

    @FXML
    public void onSignInClick(ActionEvent event) throws Exception {
        // Kiểm tra hợp lệ: code
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if(Controller.SignIn.signIn(username, password)) {
            // Hợp lệ
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            SceneManager.loadRoomView(stage);
        }
        else {
            // Không hợp lệ
            invalidSignInLabel.setStyle("-fx-text-fill: #fb0000;");
        }
    }
}
