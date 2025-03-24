package Controller;

import Model.Account;
import Model.AccountDAO;
import Model.Expenditure;
import Model.Expense;
import Utility.AddExpenseStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenditureManager {
    private static AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    public static AddExpenseStatus addExpense(String name, String costText, String payer, LocalDate paymentDate, String proofFilePath) {
        long cost;
        try {
            cost = Integer.parseInt(costText);
        }
        catch (NumberFormatException e) {
            return AddExpenseStatus.NON_INTEGER_COST;
        }

        if(paymentDate.isAfter(LocalDate.now())) {
            return AddExpenseStatus.NON_PASS_EXPENSE;
        }

        Account account = accountDAO.loadAccount();
        Expense expense = new Expense(name, cost, paymentDate, payer, proofFilePath);
        account.getRoom().getExpenditure().getExpenses().add(expense);
        accountDAO.saveAccount(account);

        return AddExpenseStatus.SUCCESS;
    }

    public static void deleteExpense(Expense expense) {
        Account account = accountDAO.loadAccount();

        account.getRoom().getExpenditure().getExpenses().removeIf(e ->
                e.getName().equals(expense.getName()) &&
                e.getCost() == expense.getCost() &&
                e.getPayer().equals(expense.getPayer()) &&
                e.getPaymentDate().equals(expense.getPaymentDate()) &&
                e.getProofFilePath().equals(expense.getProofFilePath())
        );
        accountDAO.saveAccount(account);
    }
}
