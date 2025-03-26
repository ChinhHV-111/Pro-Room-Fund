package Model;

import java.io.*;

public class AccountDAO {
    private static String filePath;
    private static AccountDAO instance;

    private AccountDAO(String username) {
        filePath = "src/main/java/Model/FileData/" + username + ".dat";
    }

    public static AccountDAO getInstance(String username) {
        if (instance == null) {
            instance = new AccountDAO(username);
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public void saveAccount(Account account) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(account);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Account loadAccount() {
        Account account = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            account = (Account) ois.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return account;
    }
}
