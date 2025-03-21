package View;

import Controller.SignUp;
import Utility.SignUpStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class SignUpView {
    private Stage stage;
    private Scene scene;
    private  Parent root;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private Label invalidSignUpLabel;

    @FXML
    public void onSignInClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/SignInView/SignInView.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        String css = getClass().getResource("/FXML/SignInView/SignInView.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSignUpClick(ActionEvent event) throws Exception {


        // Lấy username, password và confirmPassword
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        // Lấy trạng thái đăng ký
        SignUpStatus signUpStatus = SignUp.signUp(username, password, confirmPassword);

        // Nếu không hợp lệ
        if(signUpStatus != SignUpStatus.SUCCESS) {
            invalidSignUpLabel.setStyle("-fx-text-fill: #fb0000;");
            invalidSignUpLabel.setText(signUpStatus.getError());
        }
        // Nếu hợp lệ
        else {
            root = FXMLLoader.load(getClass().getResource("/FXML/SignInView/SignInView.fxml"));

            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            String css = getClass().getResource("/FXML/SignInView/SignInView.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
    }
}
