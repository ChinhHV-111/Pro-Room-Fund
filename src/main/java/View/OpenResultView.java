package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenResultView {
    @FXML
    private Label resultLabel;

    @FXML
    public void onCancelClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        stage.close();
    }

    public void setResultLabel(String result) {
        resultLabel.setText(result);
    }
}
