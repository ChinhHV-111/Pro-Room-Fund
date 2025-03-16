package Controller;

import java.io.*;
import java.util.Scanner;

public class SignIn {
    private static final String FILE_PATH = "src/main/java/Controller/account.txt";
    public static boolean signIn(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" "); // Tách username và password
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();

                    // So sánh
                    if (storedUsername.trim().equals(username.trim()) && storedPassword.equals(password.trim())) {
                        return true; // Đăng nhập thành công
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return false; // Đăng nhập thất bại
    }
}
