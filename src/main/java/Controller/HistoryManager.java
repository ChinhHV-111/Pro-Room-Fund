package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Expenditure;

public class HistoryManager {
    private static AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    public static void deleteHistory(Expenditure expenditure) {
        Account account = accountDAO.loadAccount();

        account.getRoom().getHistory().removeIf(e ->
                e.getStartDate().equals(expenditure.getStartDate()) &&
                e.getEndDate().equals(expenditure.getEndDate()) &&
                e.getTotalAmount() == expenditure.getTotalAmount() &&
                e.getResult().equals(expenditure.getResult())
        );

        accountDAO.saveAccount(account);
    }

}
