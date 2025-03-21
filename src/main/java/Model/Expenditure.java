package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Expenditure {
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
}
