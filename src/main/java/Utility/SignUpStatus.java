package Utility;

public enum SignUpStatus {
    USERNAME_AND_PASSWORD_REQUIRED("Please enter both username and password"),
    USERNAME_ALREADY_EXISTS("Username already exists"),
    USERNAME_OR_PASSWORD_CONTAINS_SPACE("Your username or password contains space"),
    NOT_MATCH_PASSWORD("Password and confirm password do not match"),
    SUCCESS("Success");

    private final String error;
    SignUpStatus(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
