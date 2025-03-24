package View;

import Controller.ExpenditureManager;
import Controller.HistoryManager;
import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Model.Expenditure;
import Model.Expense;
import Utility.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class HistoryView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Expenditure> historyTableView;
    @FXML
    private TableColumn<Expenditure, LocalDate> startDateColumn;
    @FXML
    private TableColumn<Expenditure, LocalDate> endDateColumn;
    @FXML
    private TableColumn<Expenditure, Integer> totalColumn;
    @FXML
    private TableColumn<Expenditure, Void> resultColumn;
    @FXML
    private TableColumn<Expenditure, Void> deleteColumn;

    private ObservableList<Expenditure> history = FXCollections.observableArrayList();

    public ObservableList<Expenditure> getHistory() {
        return history;
    }

    @FXML
    private void initialize() {
        Account account = accountDAO.loadAccount();
        history.setAll(account.getRoom().getHistory());
        historyTableView.setItems(history);
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        // Cột (resultColumn) với nút "View"
        resultColumn.setCellFactory(col -> new TableCell<Expenditure, Void>() {
            private final Button viewResultButton = new Button("View");

            // Edit nút
            {
                // Thiết lập sau
                viewResultButton.setStyle("");
                viewResultButton.setMaxWidth(Double.MAX_VALUE); // Mở rộng nút theo chiều rộng cột
                viewResultButton.setAlignment(Pos.CENTER);      // Căn giữa chữ trong nút
            }

            {
                viewResultButton.setOnAction(event -> {
                    Expenditure expenditure = getTableView().getItems().get(getIndex());
                    try {
                        openResult(expenditure.getResult());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    viewResultButton.setDisable(true);
                } else {
                    setGraphic(viewResultButton);
                    viewResultButton.setDisable(false);
                }
            }
        });

        // Cột (deleteColumn) với nút "Xóa"
        deleteColumn.setCellFactory(col -> new TableCell<Expenditure, Void>() {
            private final Button deleteButton = new Button("Delete");

            // Edit nút
            {
                deleteButton.setMaxWidth(Double.MAX_VALUE); // Mở rộng nút theo chiều rộng cột
                deleteButton.setAlignment(Pos.CENTER);      // Căn giữa chữ trong nút
            }

            {
                deleteButton.setOnAction(event -> {
                    Expenditure expenditure = getTableView().getItems().get(getIndex());
                    HistoryManager.deleteHistory(expenditure);
                    Account account = accountDAO.loadAccount();
                    history.setAll(account.getRoom().getHistory());
                    historyTableView.refresh();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    deleteButton.setDisable(true);
                } else {
                    setGraphic(deleteButton);
                    deleteButton.setDisable(false);
                }
            }
        });

        historyTableView.setItems(history);
    }

    public void openResult(ArrayList<String> result) throws Exception {
        Stage openResultStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/HistoryView/OpenResultView.fxml"));
        Scene openResultScene = new Scene(fxmlLoader.load());
        OpenResultView openResultView = fxmlLoader.getController();
        openResultView.setResultLabel(String.join("\n\n", result));
        openResultStage.setScene(openResultScene);
        openResultStage.show();
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
}
