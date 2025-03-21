package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Group;

import java.util.ArrayList;

public class GroupManager {
    public static void addGroup(Group group) {
        Account account = AccountDAO.loadAccount(SignIn.getAccount().getUsername());
        account.getGroups().add(group);
        AccountDAO.saveAccount(account);
    }
}
