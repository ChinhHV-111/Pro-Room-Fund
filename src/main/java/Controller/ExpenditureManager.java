package Controller;

import Model.*;
import Utility.AddExpenseStatus;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExpenditureManager {
    private static AccountDAO accountDAO = AccountDAO.getInstance(SignIn.getAccount().getUsername());

    public static AddExpenseStatus addExpense(String name, String costText, String payer, LocalDate paymentDate, String proofFilePath) {
        int cost;
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
                (e.getProofFilePath() == null || e.getProofFilePath().equals(expense.getProofFilePath()))
        );
        accountDAO.saveAccount(account);
    }

    public static ArrayList<String> calculate() {
        ArrayList<String> results = new ArrayList<>();

        // Load data và lấy list chi phí, các member
        Account account = accountDAO.loadAccount();
        ArrayList<Expense> expenses = account.getRoom().getExpenditure().getExpenses();
        TreeSet<String> members = account.getRoom().getMembers();

        ArrayList<Member> membersList = new ArrayList<>();
        for(String member : members) {
            membersList.add(new Member(member, 0));
        }

        int numberOfMembers = membersList.size();
        for(Expense expense : expenses) {
            for(int i = 0; i < numberOfMembers; i++) {
                if(expense.getPayer().equals(membersList.get(i).getName())) {
                    membersList.get(i).setTotalSpent(membersList.get(i).getTotalSpent() + expense.getCost());
                    break;
                }
            }
        }

        int averageExpense = account.getRoom().getExpenditure().getTotalAmount() / numberOfMembers;
        membersList.sort(Comparator.comparing(Member::getTotalSpent));

        for(int i = 0; i < numberOfMembers - 1; i++) {
            if(membersList.get(i).getTotalSpent() < averageExpense) {
                String result = "[" + membersList.get(i).getName() + "] pay to " + "[" + membersList.get(numberOfMembers - 1).getName() + "]: ";
                int amount = averageExpense - membersList.get(i).getTotalSpent();
                amount = Math.round((float) amount / 1000) * 1000;
                result += "\n               ";
                result += Integer.toString(amount);
                results.add(result);
            }
            else {
                String result = "[" + membersList.get(numberOfMembers - 1).getName() + "] pay to " + "[" + membersList.get(i).getName() + "]: ";
                int amount = membersList.get(i).getTotalSpent() - averageExpense;
                amount = Math.round((float) amount / 1000) * 1000;
                result += "\n               ";
                result += Integer.toString(amount);
                results.add(result);
            }
        }
        return results;
    }
}
