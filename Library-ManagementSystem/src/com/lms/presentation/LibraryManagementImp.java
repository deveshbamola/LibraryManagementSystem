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

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("| WELCOME TO LIBRARY MANAGEMENT SYSTEM |");
            System.out.println("----------------------------------------");
            System.out.println("*-----------------------*");
            System.out.println("|Contributor's--        |");
            System.out.println("|-Sanketh               |");
            System.out.println("|-Devesh                |");
            System.out.println("|-Basit                 |");
            System.out.println("|-Sushas                |");
            System.out.println("*-----------------------*");
            System.out.println("1. Employee Log in");
//          System.out.println("2. Admin Log in");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            showOperations(choice);
        }
    }

    public void showOperations(int choice) {
        switch (choice) {
            case 1 -> employeeLogin();
            case 2 -> adminLogin();
            case 3 -> System.exit(0);
        }
    }

    public void employeeLogin() {

        String email, pass;
        System.out.println("---------Log-in---------\n");
        System.out.println("Enter email : \n");
        scanner.nextLine();
        email = scanner.nextLine();
        System.out.println("Enter Passcode : \n");
        pass = scanner.nextLine();
        String qry = "Select employeeId from user where email=? and pass=?";
        int empId = employeeService.checkUser(email, pass);
        if (empId == -1) {
            System.out.println("User does not exit");
        } else if (empId == 0) {
            System.out.println("Welcome : " + email);

            //check user Exist Select * from employee table where email=? and pass=?
            int choice;
            do {
                System.out.println("1. Show All Books ");
                System.out.println("2. Search Book by Name");
                System.out.println("3. Take book  *");
                System.out.println("4. Check Due Return Date *");
                System.out.println("5. Pay Fine *");
                System.out.println("6. Return Book *");
                System.out.println("7. Log out");
                System.out.println("Enter your choice : ");
                choice = scanner.nextInt();

                performEmployeeMenu(choice);
            } while (choice != 7);
            System.out.println(email + ": Logging out Successfully");
        } else {
            System.out.println("Welcome : " + email);

            int choice;
            do {

                System.out.println("1. Show all Employees");
                System.out.println("2. Search Employee by ID");
                System.out.println("3. Add Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Add Book ");
                System.out.println("6. Remove Book ");
                System.out.println("7. Log out");
                System.out.println("Enter your choice : ");
                choice = scanner.nextInt();
                performAdminMenu(choice);
            } while (choice != 7);
            System.out.println(email + ": Logging out Successfully");
        }
    }

    @Override
    public void performEmployeeMenu(int choice) {
        switch (choice) {
            case 1:
                getAllBooks();
                break;
            case 2:
                searchBook();
                break;

            case 3://Take book
                issueBook();
                break;

            case 4://Check Due Return Date
                checkDueReturnDate();
                break;

            case 5://Pay Fine
                break;

            case 6://Return Book
                break;
            case 7://Log out
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

    public void adminLogin() {

//   	 String email,pass;
//   	 
//   	 System.out.println("------A*---Log-in---A*------\n");
//   	 System.out.println("Enter email : \n");
//   	 scanner.nextLine();
//   	 email=scanner.nextLine();
//   	
//   	 System.out.println("Enter Passcode : \n");
//   	 
//   	 pass=scanner.nextLine();
//
//   	 //check user Exist Select * from admin table where email=? and pass=?
//   	 
//   	 int choice;
//   	 do {
//   		
//   		 System.out.println("1. Show all Employees");
//   		 System.out.println("2. Search Employee by ID");
//   		 System.out.println("3. Add Employee");
//   		 System.out.println("4. Delete Employee");
//   		 System.out.println("5. Add Book ");
//   		 System.out.println("6. Remove Book ");
//   		 System.out.println("7. Log out");
//   		 System.out.println("Enter your choice : ");
//   		choice=scanner.nextInt();
//   	     performAdminMenu(choice);
//   	 }while(choice!=7);
//	 System.out.println(email+": Logging out Successfully");


    }

    @Override
    public void performAdminMenu(int choice) {
        switch (choice) {
            case 1:
                getAllEmployees();
                break;
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
                addBook();
                break;
            case 6:
                removeBook();
                break;
            case 7:
                //log out
                break;

            default:
                System.out.println("Invalid choice");
                break;

        }
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

        Employee employee = new Employee(empID, empFirstName, empFirstName, designation, 0);
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
        System.out.println("Enter Book Name: \n");
        scanner.nextLine();
        String name = scanner.nextLine();
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

    private void removeBook() {
        System.out.println("Enter Book Name");
        String name = scanner.next();
        System.out.println(bookService.removeBook(name) ? "Success" : "Failed");
    }

    private void issueBook() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bid = scanner.nextInt();
        System.out.print("Enter Scheduled Return Date");
        String date = scanner.next();
        System.out.println(bookService.issueBook(id, bid, date));
    }

    private void checkDueReturnDate() {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        System.out.println("Enter book ID:");
        int bookId = scanner.nextInt();
        System.out.println(bookService.checkDueReturnDate(id, bookId));
    }

    private void returnBook() {
        System.out.println("Enter TransactionID:");
        int bookId = scanner.nextInt();
    }

    @Override
    public void performMenu(int choice) {
        // TODO Auto-generated method stub

    }
}
