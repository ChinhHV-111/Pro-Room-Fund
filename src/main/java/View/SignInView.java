package View;

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
        root = FXMLLoader.load(getClass().getResource("/FXML/SignUpView/SignUpView.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSignInClick(ActionEvent event) throws Exception {
        // Kiểm tra hợp lệ: code
        // Nếu valid: code
        // Nếu invalid:
        invalidSignInLabel.setStyle("-fx-text-fill: #fb0000;");
    }
}
