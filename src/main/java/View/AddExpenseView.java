package View;

import Controller.ExpenditureManager;
import Controller.SignIn;
import Model.Account;
import Model.AccountDAO;
import Utility.AddExpenseStatus;
import Utility.ImageProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddExpenseView {
    private AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String proofFilePath;

    @FXML
    private Label invalidAddExpenseLabel;
    @FXML
    private Button chooseAnImageButton;
    @FXML
    private CheckBox proofCheckBox;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField costTextField;
    @FXML
    private ChoiceBox<String> payerChoiceBox;
    @FXML
    private DatePicker paymentDatePicker;

    @FXML
    public void initialize() {
        // Thêm dữ liệu vào payerChoiceBox
        Account account = accountDAO.loadAccount();
        payerChoiceBox.getItems().setAll(account.getRoom().getMembers());

        // Mặc định vô hiệu hoá button chọn file ảnh
        chooseAnImageButton.setDisable(true);

        // Định dạng ngày thành "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Sử dụng setConverter để định dạng lại text trong DatePicker sau khi chọn và định dạng lại ngày sau khi nhập
        paymentDatePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                return (date != null) ? formatter.format(date) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty()) ? LocalDate.parse(string, formatter) : null;
            }
        });
    }

    @FXML
    public void onChooseAnImageClick(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        // Thiết lập tiêu đề cho hộp thoại
        fileChooser.setTitle("Chọn một tệp");

        // Chỉ cho phép chọn file .png hoặc .jpg
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Hình ảnh (*.png, *.jpg)", "*.png", "*.jpg"));

        // Lấy cửa sổ hiện tại từ nút
        Stage stage = (Stage) nameTextField.getScene().getWindow();

        // Mở hộp thoại
        File selectedFile = fileChooser.showOpenDialog(stage);

        // Kiểm tra nếu người dùng đã chọn file
        if (selectedFile != null) {
            proofFilePath = ImageProcessor.copyImageToSourceFolder(selectedFile);
        }
    }

    @FXML
    public void changeProofCheckBox(ActionEvent event) throws IOException {
        if(proofCheckBox.isSelected()) {
            chooseAnImageButton.setDisable(false);
        }
        else {
            chooseAnImageButton.setDisable(true);
        }
    }

    @FXML
    public void addExpenseClick(ActionEvent event) throws Exception {
        String name = nameTextField.getText();
        String costText = costTextField.getText();
        String payer = payerChoiceBox.getValue();
        LocalDate paymentDate = paymentDatePicker.getValue();
        if(!proofCheckBox.isSelected()) {
            proofFilePath = null;
        }

        AddExpenseStatus addExpenseStatus = ExpenditureManager.addExpense(name, costText, payer, paymentDate, proofFilePath);

        if(addExpenseStatus != AddExpenseStatus.SUCCESS) {
            invalidAddExpenseLabel.setText(addExpenseStatus.getStatus());
            invalidAddExpenseLabel.setStyle("-fx-text-fill: #fb0000;");
        }
        else {
            Stage stage = (Stage) invalidAddExpenseLabel.getScene().getWindow();
            stage.close();
        }
    }
}
