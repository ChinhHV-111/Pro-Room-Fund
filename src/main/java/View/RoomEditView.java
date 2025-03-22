package View;

import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Utility.SceneManager;
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
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

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
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getRoomViewScene();

        Account account = accountDAO.loadAccount();
        RoomView roomView = SceneManager.getRoomView();
        roomView.setNameLabel(account.getRoom().getName());
        roomView.setNumberOfResidentsLabel(account.getRoom().getMembers().size());
        roomView.setDescriptionLabel(account.getRoom().getDescription());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMemberClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getMemberViewScene();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onExpenditureClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getExpenditureViewScene();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onHistoryClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getHistoryViewScene();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onLogOutClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        SceneManager.loadSignInView(stage);
    }

    //--------------------------------------------------------------------------------------//
    @FXML
    public void onSaveRoomClick(ActionEvent event) throws Exception {
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getRoomViewScene();
        RoomView roomView = SceneManager.getRoomView();

        String roomName = nameTextArea.getText();
        String roomDescription = descriptionTextArea.getText();

        roomView.setNameLabel(roomName);
        roomView.setDescriptionLabel(roomDescription);
        // Lấy và lưu cơ bản
        Account account = accountDAO.loadAccount();
        account.getRoom().setName(roomName);
        account.getRoom().setDescription(roomDescription);
        accountDAO.saveAccount(account);

        stage.setScene(scene);
        stage.show();
    }
}
