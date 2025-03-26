package Model;

public class Member {
    private String name;
    private int totalSpent;

    public Member(String name, int totalSpent) {
        this.name = name;
        this.totalSpent = totalSpent;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSpent() {
        return totalSpent;
    }
    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }
}
