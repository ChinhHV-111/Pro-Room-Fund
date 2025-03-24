package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Expenditure implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private ArrayList<Expense> expenses;
    private int totalAmount;
    private ArrayList<String> result;

    public Expenditure(LocalDate startDate) {
        this.startDate = startDate;
        this.expenses = new ArrayList<>();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.name = "From [" + startDate.format(formatter) + "] to [" + endDate.format(formatter) + "]";
        return name;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public int getTotalAmount() {
        totalAmount = 0;
        for (Expense expense : expenses) {
            totalAmount += expense.getCost();
        }
        return totalAmount;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }
}
