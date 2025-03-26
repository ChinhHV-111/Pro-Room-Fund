package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Room;

public class RoomManager {
    private static AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    private static String normalizeTheName(String name){
        String[] words = name.split(" ");
        name = "";
        int numberOfWords = words.length;
        for(int i = 0; i < numberOfWords; i++){
           words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
           name += words[i];
           if(i < numberOfWords - 1){
               name += " ";
           }
        }
        return name;
    }

    public static boolean addMember(String member) {
        // Chuẩn hoá lại tên
        member = normalizeTheName(member);

        Account account = accountDAO.loadAccount();
        if(account.getRoom().getMembers().contains(member)) {
            return false;
        }
        else {
            account.getRoom().getMembers().add(member);
            accountDAO.saveAccount(account);
            return true;
        }
    }

    public static void removeMember(String member) {
        Account account = accountDAO.loadAccount();
        account.getRoom().getMembers().remove(member);
        accountDAO.saveAccount(account);
    }
}
