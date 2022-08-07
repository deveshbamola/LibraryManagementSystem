package com.lms.presentation;

import com.lms.bean.Book;
import com.lms.bean.Employee;
import com.lms.service.BookService;
import com.lms.service.BookServiceImpl;
import com.lms.service.EmployeeService;
import com.lms.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

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
            	issueBook();
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
        System.out.println("Enter Book Name: ");
        String name = scanner.next();
        System.out.println("Enter ISBN Number: ");
        int isbn_number = scanner.nextInt();
        System.out.println("Enter Author Name: ");
        String authorName = scanner.next();
        System.out.println("Enter Publisher Name: ");
        String publisherName = scanner.next();
        System.out.println("Enter Book Type: ");
        String bookType = scanner.next();
        System.out.println("Enter Number of Books: ");
        int bookNum = scanner.nextInt();
        Book book = new Book(name, isbn_number, authorName, publisherName, bookType, bookNum);
        System.out.println(bookService.addBook(book) ? "Success" : "Failed");

    }
    private void issueBook() {
    	System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bid = scanner.nextInt();
        System.out.print("Enter Scheduled Return Date");
        String date = scanner.next();
         System.out.println( bookService.issueBook(id, bid, date));
    }

    private void removeBook() {
        System.out.println("Enter Book Name");
        String name = scanner.next();
        System.out.println(bookService.removeBook(name) ? "Success" : "Failed");
    }

    private void getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        if (bookList == null) {
            System.out.println("No Employee Found");
            return;
        }
        for (Book book : bookList)
            System.out.println(book);
    }
}
