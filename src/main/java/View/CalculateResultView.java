package View;

import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Utility.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class CalculateResultView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        resultLabel.setText(String.join("\n\n", SceneManager.getExpenditureView().getResult()));
    }

    @FXML
    public void onSaveClick(ActionEvent event) throws IOException {
//        // Xoá dữ liệu trong TableView của Expenditure
//        SceneManager.getExpenditureView().getExpenses().clear();
//        // Thiết lập đủ dữ liệu cho object expenditure trong Class Room và đẩy và ArrayList<Expenditure> history, đồng thời thiết lập lại expenditure mới
//        Account account = accountDAO.loadAccount();
//        account.getRoom().getExpenditure().setEndDate(LocalDate.now());
//        account.getRoom().getExpenditure().setResult(SceneManager.getExpenditureView().getResult());
    }

    @FXML
    private void onCancelClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        stage.close();
    }
}
