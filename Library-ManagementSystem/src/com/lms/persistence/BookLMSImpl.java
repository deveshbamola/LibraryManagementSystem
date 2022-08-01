package com.lms.persistence;

import com.lms.bean.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookLMSImpl implements BookLMSDAO {
    @Override
    public boolean addBook(Book book) {
        int rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--", "",
                "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("INSERT INTO EMPLOYEE values(?,?,?,?,?,?)");) {

//            preparedStatement.setInt(1, );
//            preparedStatement.setString(2, employee.getEmpName());
//            preparedStatement.setString(3, employee.getEmpDesignation());
//            preparedStatement.setString(4, employee.getEmpEmail());
//            preparedStatement.setString(5, employee.getEmpDepartment());
//            preparedStatement.setDouble(6, employee.getEmpSalary());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    @Override
    public Integer removeBook(int bookID) {
        Integer rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--",
                "", "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("DELETE FROM Books WHERE BOOK_ID=?");) {

            preparedStatement.setInt(1, bookID);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return rows;
    }

    @Override
    public Book searchBook(int bookID) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--",
                "", "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM BOOKS WHERE BOOK_ID=?");) {

            preparedStatement.setInt(1, bookID);


        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return book;
    }
}
