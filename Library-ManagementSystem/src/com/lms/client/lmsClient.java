package com.lms.client;
import com.lms.presentation.*;

public class lmsClient {
    public static void main(String[] args) {
        LibraryManagementImp projectManagePresentation = new LibraryManagementImp();
        while (true) {
            projectManagePresentation.showMenu();
        }
    }
}
