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
import javafx.stage.Stage;

public class ExpenditureView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private Stage stage;
    private Scene scene;
    private Parent root;

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
}
