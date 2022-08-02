package com.lms.presentation;

import com.lms.bean.*;
import com.lms.service.*;

import java.util.*;

public class LibraryManagementImp implements LibraryManagementPresentation {
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeServiceImpl();
    BookService bookService = new BookServiceImpl();

    @Override
    public void showMenu() {
        System.out.println("1. Show All Employees");
        System.out.println("2. Search Employee by ID");
        System.out.println("3. Add Employee");
        System.out.println("4. Delete Employee");
        System.out.println("------------------");
        System.out.println("5. Show All Books");
        System.out.println("6. Search Book by Name");
        System.out.println("7. Add Book");
        System.out.println("8. Remove Book");
        System.out.println("------------------");
        System.out.println("9. Issue Book");
        System.out.println("10. Return Book");
        System.out.println("11. Check Due Return Date");
        System.out.println("12. Pay Fine");
        int choice = scanner.nextInt();
        performMenu(choice);

    }

    @Override
    public void performMenu(int choice) {
        switch (choice) {
            case 1:
                getAllEmployees();
            case 2:
                searchEmployee();
                break;
            case 3:
                addEmployee();
                break;
            case 4:
                deleteEmployee();
                break;
            case 5:
                break;
            case 6:
                searchBook();
                break;
            case 7:
                addBook();
                break;
            case 8:
                removeBook();
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.exit(0);

        }
    }

    private void getAllEmployees() {
        List<Employee> empList = employeeService.getAllEmployees();
        if (empList == null) {
            System.out.println("No Employee Found");
            return;
        }
        for (Employee employee : empList)
            System.out.println(employee);
    }

    private void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int empID = scanner.nextInt();
        System.out.print("Enter Employee First Name: ");
        String empFirstName = scanner.next();
        System.out.print("Enter Employee Last Name: ");
        String empLastName = scanner.next();
        System.out.println("Enter Designation: ");
        String designation = scanner.next();
        System.out.println("Enter Employee Phone Number: ");
        long empPhoneNumber = scanner.nextLong();
        Employee employee = new Employee(empID, empFirstName, empFirstName, designation, 0, empPhoneNumber);
        System.out.println(employeeService.addEmployee(employee) ? "Success !!" : "Failure");
    }

    private void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int empID = scanner.nextInt();
        if (employeeService.removeEmployee(empID))
            System.out.println("Employee Deleted Successfully");
        else
            System.out.println("Operation Failed");

    }

    private void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee employee = employeeService.searchEmployee(id);
        if (employee != null) {
            System.out.println(employee);
        } else System.out.println("Employee With ID " + id + " Does Not Exist");
    }

    private void searchBook() {
        System.out.println("Enter Book Name: ");
        String name = scanner.next();
        Book book = bookService.searchBook(name);
        if (book != null)
            System.out.println(book);
        else
            System.out.println("Book Does Not Exist");
    }

    private void addBook() {

    }

    private void removeBook() {

    }
}
