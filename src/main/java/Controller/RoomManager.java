package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Room;

public class RoomManager {
    private static AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());
    public static void editRoom(Room room) {
        Account account = accountDAO.loadAccount();
        account.setRoom(room);
        accountDAO.saveAccount(account);
    }

    public static void addMember(String member) {
        Account account = accountDAO.loadAccount();
        // Có thể xử lý thêm trường hợp bằng null
        if(account.getRoom() != null) {
            account.getRoom().getMembers().add(member);
        }
        accountDAO.saveAccount(account);
    }
}
