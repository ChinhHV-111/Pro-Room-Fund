package Model;

import java.time.LocalDate;

public class Expense {
    private String name;
    private long cost;
    private LocalDate paymentDate;
    private String payer;
    private String proofFilePath;

    public Expense(String name, long cost, LocalDate paymentDate, String payer, String proofFilePath) {
        this.name = name;
        this.cost = cost;
        this.paymentDate = paymentDate;
        this.payer = payer;
        this.proofFilePath = proofFilePath;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }
    public void setCost(long cost) {
        this.cost = cost;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayer() {
        return payer;
    }
    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getProofFilePath() {
        return proofFilePath;
    }
    public void setProofFilePath(String proofFilePath) {
        this.proofFilePath = proofFilePath;
    }
}
