package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private String imageFilePath;
    private TreeSet<String> members;
    private Expenditure expenditure;
    private ArrayList<Expenditure> history;

    public Room(String name, String description, String imageFilePath) {
        this.name = name;
        this.description = description;
        this.imageFilePath = imageFilePath;

        members = new TreeSet<>();

        LocalDate today = LocalDate.now();
        expenditure = new Expenditure(today);

        history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }
    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public TreeSet<String> getMembers() {
        return members;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }
    public void setExpenditure(Expenditure expenditure) {
        this.expenditure = expenditure;
    }

    public ArrayList<Expenditure> getHistory() {
        return history;
    }
}
