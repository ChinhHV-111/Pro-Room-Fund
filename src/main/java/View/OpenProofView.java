package View;

import Model.Expense;
import Utility.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

public class OpenProofView {
    @FXML
    private ImageView proofImageView;

    public void setImage(String filePath) {
        InputStream stream = getClass().getResourceAsStream(filePath);
        if (stream == null) {
            System.out.println("Không tìm thấy: " + filePath);
        }
        else {
            Image proof = new Image(stream);
            proofImageView.setImage(proof);
        }
    }
}
