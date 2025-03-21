package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Room;

public class RoomManager {
    public static void editRoom(Room room) {
        Account account = AccountDAO.loadAccount(SignIn.getAccount().getUsername());
        // code sau
        AccountDAO.saveAccount(account);
    }

    public static void addMember(String member) {
        Account account = AccountDAO.loadAccount(SignIn.getAccount().getUsername());
        // Có thể xử lý thêm trường hợp bằng null
        if(account.getRoom() != null) {
            account.getRoom().getMembers().add(member);
        }
        AccountDAO.saveAccount(account);
    }
}
