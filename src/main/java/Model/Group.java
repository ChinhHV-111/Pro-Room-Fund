package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Group {
    private String name;
    private String description;
    private ArrayList<String> members;
    private Expenditure expenditure;
    private ArrayList<Expenditure> history;

    public Group(String name, String description) {
        this.name = name;
        this.description = description;

        members = new ArrayList<>();

        LocalDate today = LocalDate.now();
        expenditure = new Expenditure(today);

        history = new ArrayList<>();
    }
}
