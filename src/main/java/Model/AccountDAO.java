package Model;

import java.io.*;

public class AccountDAO {
    public static void saveAccount(Account account) {
        String filePath = "src/main/java/Model/FileData/" + account.getUsername() + ".dat";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(account);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Account loadAccount(String username) {
        Account account = null;
        String filePath = "src/main/java/Model/FileData/" + username + ".dat";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            account = (Account) ois.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return account;
    }
}
