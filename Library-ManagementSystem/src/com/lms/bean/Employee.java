package com.lms.bean;


public class Employee {

    private int employeeId;
    private String empFirstName;
    private String empLastName;
    private String designation;
    private int numberOfBooksIssued;
    private long phoneNumber;

    public Employee(int employeeId, String empFirstName, String empLastName, String designation, int numberOfBooksIssued, long phoneNumber) {
        this.employeeId = employeeId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.designation = designation;
        this.numberOfBooksIssued = numberOfBooksIssued;
        this.phoneNumber = phoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public int getNumberOfBooksIssued() {
        return numberOfBooksIssued;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public void setNumberOfBooksIssued(int numberOfBooksIssued) {
        this.numberOfBooksIssued = numberOfBooksIssued;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", numberOfBooksIssued=" + numberOfBooksIssued +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
