package com.lms.client;

import com.lms.presentation.LibraryManagementImp;

public class ClientM {

    public static void main(String[] args) {
        LibraryManagementImp presentObj = new LibraryManagementImp();
        while (true) {
            presentObj.showMenu();
        }
    }

}
