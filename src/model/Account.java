package model;

import java.time.LocalDate;

public class Account extends Staff{
    private String userName;
    private String password;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(int idStaff, String fullName, String gender, LocalDate dateOfBirth, String role, int phoneNumber, String userName, String password) {
        super(idStaff, fullName, gender, dateOfBirth, role, phoneNumber);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
