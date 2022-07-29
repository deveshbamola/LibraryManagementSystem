package com.lms.presentation;

import java.util.*;

public class LibraryManagementImp implements LibraryManagementPresentation {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("1. Show All Employees");
        System.out.println("2. Search Employee by ID");
        System.out.println("3. Add Employee");
        System.out.println("4. Delete Employee");
        System.out.println("------------------");
        System.out.println("5. Show All Books");
        System.out.println("6. Search Book by Author");
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
//
        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.exit(0);

        }
    }
}
