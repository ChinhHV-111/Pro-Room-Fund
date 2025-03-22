package Controller;

import Model.Account;
import Model.AccountDAO;

import java.io.*;
import java.util.Scanner;

public class SignIn {
    private static Account account;

    public static Account getAccount() {
        return account;
    }

    private static final String filePath = "src/main/java/Model/FileData/account.txt";
    private static AccountDAO accountDAO;

    public static boolean signIn(String username, String password) {
        username = username.trim();
        password = password.trim();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" "); // Tách username và password
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();

                    // So sánh
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        AccountDAO.resetInstance();
                        accountDAO = AccountDAO.getInstance(username);
                        account = accountDAO.loadAccount();
                        return true; // Đăng nhập thành công
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false; // Đăng nhập thất bại
    }
}
