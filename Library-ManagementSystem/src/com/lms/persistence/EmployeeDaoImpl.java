package com.lms.persistence;

import com.lms.bean.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Integer addEmployee(Employee employee) {
        Integer rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/--",
                "", "");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("INSERT INTO Employees VALUES(?,?,?,?,?,?)");) {

            preparedStatement.setInt(1, employee.getEmpID());
            preparedStatement.setString(2, employee.getEmpName());
            preparedStatement.setLong(3, employee.getEmpPhoneNumber());
            preparedStatement.setBoolean(4, employee.getIsAdmin());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setInt(6, employee.getBookLimit());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return rows;
    }

    @Override
    public Integer removeEmployee(int empID) {
        return null;
    }

    @Override
    public Employee searchEmployee(int empID) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
