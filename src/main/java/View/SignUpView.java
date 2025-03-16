package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpView {
    private Stage stage;
    private Scene scene;
    private  Parent root;

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
}
