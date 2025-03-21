package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private ArrayList<Group> groups;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.groups = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Group> getGroups() {
        return new ArrayList<>(groups);
    }
}
