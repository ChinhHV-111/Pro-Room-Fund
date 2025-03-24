package Utility;

import Controller.SignIn;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageProcessor {
    public static String copyImageToSourceFolder(File sourceFile) {
        // Định nghĩa thư mục lưu ảnh (cùng cấp với thư mục chạy chương trình)
        File destinationFolder = new File("user_images");

        // Tạo thư mục nếu chưa tồn tại
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        // Định nghĩa file đích
        String nameDestinationFile = SignIn.getAccount().getUsername() + "_" + sourceFile.getName();
        File destinationFile = new File(destinationFolder, nameDestinationFile);

        try {
            // Copy file vào thư mục `user_images/`
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return destinationFile.getAbsolutePath(); // Trả về đường dẫn tuyệt đối của ảnh
        } catch (IOException e) {
            System.err.println("Lỗi khi sao chép ảnh: " + e.getMessage());
        }
        return null;
    }
}
