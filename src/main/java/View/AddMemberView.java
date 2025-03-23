package View;

import Controller.RoomManager;
import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Utility.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMemberView {
    AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());
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
        Account account = accountDAO.loadAccount();
        SceneManager.getMemberView().updateMemberList(account.getRoom().getMembers());
        Stage stage = (Stage) nameOfNewMemberTextField.getScene().getWindow();
        stage.close();
    }
}
