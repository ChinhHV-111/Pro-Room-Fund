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
}
