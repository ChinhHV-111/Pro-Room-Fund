package View;

import Controller.RoomManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMemberView {
    @FXML
    private TextField nameOfNewMemberTextField;
    @FXML
    private Label invalidAddMemberLabel;

    @FXML
    public void onAddMemberClick(ActionEvent event) throws IOException {
        String nameOfNewMember = nameOfNewMemberTextField.getText();
        if(!RoomManager.addMember(nameOfNewMember)) {
            invalidAddMemberLabel.setStyle("-fx-text-fill: #fb0000;");
            return;
        }
        Stage stage = (Stage) nameOfNewMemberTextField.getScene().getWindow();
        stage.close();
    }
}
