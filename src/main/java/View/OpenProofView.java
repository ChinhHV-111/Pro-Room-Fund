package View;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class OpenProofView {
    @FXML
    private ImageView proofImageView;

    public void setImage(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Không tìm thấy ảnh: " + file.getAbsolutePath());
            return;
        }

        // Load ảnh từ file hệ thống
        Image proof = new Image(file.toURI().toString());
        proofImageView.setImage(proof);
    }
}
