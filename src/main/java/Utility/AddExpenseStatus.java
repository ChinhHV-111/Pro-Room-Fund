package Utility;

public enum AddExpenseStatus {
    NON_INTEGER_COST("Cost must be an integer"),
    NON_PASS_EXPENSE("Expense must be in the past"),
    SUCCESS("Success");

    private final String status;

    AddExpenseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
