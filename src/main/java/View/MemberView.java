package View;

import Controller.RoomManager;
import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Utility.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.lang.reflect.Member;
import java.util.TreeSet;

public class MemberView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<String> memberListView;

    private ObservableList<String> memberList = FXCollections.observableArrayList();
    private String currentMember;

    public void updateMemberList(TreeSet<String> members) {
        memberList.setAll(members);
    }

    @FXML
    public void initialize() {
        Account account = accountDAO.loadAccount();
        memberList.setAll(account.getRoom().getMembers());
        memberListView.setItems(memberList);

        memberListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                currentMember = newValue.toString();
            }
        });
    }

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

    @FXML
    public void onAddNewClick(ActionEvent event) throws Exception {
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = SceneManager.getMemberViewScene();

        Stage subStage = new Stage();
        SceneManager.loadStage(subStage, "/FXML/MemberView/AddMemberView.fxml", "/FXML/MemberView/AddMemberView.css");

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onDeleteClick(ActionEvent event) throws Exception {
        RoomManager.removeMember(currentMember);
        Account account = accountDAO.loadAccount();
        memberList.setAll(account.getRoom().getMembers());
        memberListView.setItems(memberList);
    }
}
