package model;

import java.time.LocalDate;

public class Staff extends Role{
    private int idStaff;
    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private String role;
    private int phoneNumber;

    public Staff() {
    }

    public Staff(int idStaff, String fullName, String gender, LocalDate dateOfBirth, String role, int phoneNumber) {
        this.idStaff = idStaff;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public Staff(int idRole, String nameRole, int idStaff, String fullName, String gender, LocalDate dateOfBirth, String role, int phoneNumber) {
        super(idRole, nameRole);
        this.idStaff = idStaff;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role='" + role + '\'' +
                ", phoneNumber=" + phoneNumber +
                "} " + super.toString();
    }
}
