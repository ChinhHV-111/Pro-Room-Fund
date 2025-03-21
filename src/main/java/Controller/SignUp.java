package Controller;

import Model.Account;
import Model.AccountDAO;
import Utility.SignUpStatus;

import java.io.*;

public class SignUp {
    private static final String filePath = "src/main/java/Model/FileData/account.txt";

    public static void createAccount(String username, String password) {
        String filePath = "src/main/java/Model/FileData/" + username + ".dat";
        Account account = new Account(username, password);

        AccountDAO.saveAccount(account);
    }

    public static SignUpStatus signUp(String username, String password, String confirmPassword) {
        username = username.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        // Kiểm tra username already exits
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" "); // Tách username và password
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();

                    if (storedUsername.equals(username)) {
                        return SignUpStatus.USERNAME_ALREADY_EXISTS;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Kiểm tra username hoặc password có trống hay không
        if(username == "" || password == "" || confirmPassword == "") {
            return SignUpStatus.USERNAME_AND_PASSWORD_REQUIRED;
        }

        // Kiểm tra username hoặc password có chứa dấu cách hay không
        if(username.contains(" ") || password.contains(" ") || confirmPassword.contains(" ")) {
            return SignUpStatus.USERNAME_OR_PASSWORD_CONTAINS_SPACE;
        }

        // Kiểm tra 2 mật khẩu có trùng lặp hay không
        if(!password.equals(confirmPassword)) {
            return SignUpStatus.NOT_MATCH_PASSWORD;
        }

        // Tất cả đều hợp lệ => Ghi tài khoản vào file, tạo file của tài khoản bằng ObjectInputStream
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(username + " " + password + "\n");
            createAccount(username, password);
            return SignUpStatus.SUCCESS;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
