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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileyc256", "root",
                "sujata");
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
}
