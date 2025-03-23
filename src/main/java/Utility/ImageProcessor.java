package Utility;

import Controller.SignIn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageProcessor {
    public static String copyImageToSourceFolder(File sourceFile) {
        // Định nghĩa thư mục lưu ảnh (thư mục nằm trong source code)
        File destinationFolder = new File("src/main/resources/ImageFromUser");

        // Tạo thư mục nếu chưa tồn tại
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        // Định nghĩa file đích
        String nameDestinationFile = SignIn.getAccount().getUsername() + "_" + sourceFile.getName();
        File destinationFile = new File(destinationFolder, nameDestinationFile);

        try {
            // Copy file vào thư mục source
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String destinationFilePath = destinationFile.getPath();
            // Để bỏ đi đoạn "src\main\resources"
            destinationFilePath = destinationFilePath.substring(18);
            destinationFilePath = destinationFilePath.replace("\\", "/");

            return destinationFilePath;
        } catch (IOException e) {
            System.err.println("Lỗi khi sao chép ảnh: " + e.getMessage());
        }
        return null;
    }
}
