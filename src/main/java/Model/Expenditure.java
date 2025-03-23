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
    private long totalAmount;

    public Expenditure(LocalDate startDate) {
        this.startDate = startDate;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.name = "From [" + startDate.format(formatter) + "]";

        this.expenses = new ArrayList<>();

        this.totalAmount = 0;
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
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public long getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
