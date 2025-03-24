package View;

import Controller.ExpenditureManager;
import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
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

import java.io.IOException;
import java.util.ArrayList;

public class ExpenditureView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Expense> expenseTableView;
    @FXML
    private TableColumn<Expense, String> nameColumn;
    @FXML
    private TableColumn<Expense, Integer> costColumn;
    @FXML
    private TableColumn<Expense, String> payerColumn;
    @FXML
    private TableColumn<Expense, String> paymentDateColumn;
    @FXML
    private TableColumn<Expense, Void> proofColumn;
    @FXML
    private TableColumn<Expense, Void> deleteColumn;

    private ObservableList<Expense> expenses = FXCollections.observableArrayList();
    ArrayList<String> result;

    public ObservableList<Expense> getExpenses() {
        return expenses;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    @FXML
    private void initialize() {
        Account account = accountDAO.loadAccount();
        expenses.setAll(account.getRoom().getExpenditure().getExpenses());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        payerColumn.setCellValueFactory(new PropertyValueFactory<>("payer"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        // Cột (proofColumn) với nút "Xem"
        proofColumn.setCellFactory(col -> new TableCell<Expense, Void>() {
            private final Button viewProofButton = new Button("View");

            // Edit nút
            {
                // Thiết lập sau
                viewProofButton.setStyle("");
                viewProofButton.setMaxWidth(Double.MAX_VALUE); // Mở rộng nút theo chiều rộng cột
                viewProofButton.setAlignment(Pos.CENTER);      // Căn giữa chữ trong nút
            }

            {
                viewProofButton.setOnAction(event -> {
                    Expense expense = getTableView().getItems().get(getIndex());
                    try {
                        openProof(expense);
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
                    viewProofButton.setDisable(true);
                } else {
                    setGraphic(viewProofButton);
                    viewProofButton.setDisable(false);
                    Expense expense = getTableView().getItems().get(getIndex());
                    if(expense.getProofFilePath() == null) {
                        viewProofButton.setDisable(true);
                    }
                }
            }
        });

        // Cột (deleteColumn) với nút "Xóa"
        deleteColumn.setCellFactory(col -> new TableCell<Expense, Void>() {
            private final Button deleteButton = new Button("Delete");

            // Edit nút
            {
                deleteButton.setMaxWidth(Double.MAX_VALUE); // Mở rộng nút theo chiều rộng cột
                deleteButton.setAlignment(Pos.CENTER);      // Căn giữa chữ trong nút
            }

            {
                deleteButton.setOnAction(event -> {
                    Expense expense = getTableView().getItems().get(getIndex());
                    ExpenditureManager.deleteExpense(expense);
                    Account account = accountDAO.loadAccount();
                    expenses.setAll(account.getRoom().getExpenditure().getExpenses());
                    expenseTableView.refresh();
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

        expenseTableView.setItems(expenses);
    }

    public void openProof(Expense expense) throws Exception {
        Stage openProofStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ExpenditureView/OpenProof.fxml"));
        Scene openProofScene = new Scene(loader.load());
        OpenProofView openProofView = loader.getController();
        openProofView.setImage(expense.getProofFilePath());
        openProofStage.setScene(openProofScene);
        openProofStage.show();
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
        Stage subStage = new Stage();
        SceneManager.loadStage(subStage, "/FXML/ExpenditureView/AddExpenseView.fxml", "/FXML/ExpenditureView/AddExpenseView.css");
    }

    @FXML
    public void onCalculateClick(ActionEvent event) throws Exception {
        result = ExpenditureManager.calculate();
        Stage subStage = new Stage();
        SceneManager.loadStage(subStage, "/FXML/ExpenditureView/CalculateResult.fxml", "/FXML/ExpenditureView/CalculateResult.css");
    }
}