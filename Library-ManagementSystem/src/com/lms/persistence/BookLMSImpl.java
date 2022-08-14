package com.lms.persistence;

import com.lms.bean.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookLMSImpl implements BookLMSDAO {
    String pass = "devesh_bamola";

    @Override
    public boolean addBook(Book book) {
        int rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement = connection
                     .prepareStatement("INSERT INTO book values(?, ?, ?, ?, ?, ?, ?)");
             PreparedStatement preparedStatement1 = connection
                     .prepareStatement("SELECT bookId FROM book  WHERE bookid=?");) {

            int f = 0;
            int rand = 0;
            while (f == 0) {
                int max = 10000;
                int min = 20000;
                int range = max - min + 1;
                rand = (int) (Math.random() * range) + min;
                preparedStatement1.setInt(1, rand);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                if (!resultSet1.next()) {
                    f = 1;
                }
            }

            preparedStatement.setInt(1, rand);
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setInt(3, book.getIsbnNumber());
            preparedStatement.setString(4, book.getAuthorName());
            preparedStatement.setString(5, book.getPublisherName());
            preparedStatement.setString(6, book.getBookType());
            preparedStatement.setInt(7, book.getBookNumber());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    @Override
    public int removeBook(String bookName) {
        int rows = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement = connection
                     .prepareStatement("DELETE FROM book WHERE bookName=?")) {

            preparedStatement.setString(1, bookName);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rows;
    }

    @Override
    public Book searchBook(String name) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM book  WHERE bookName=?");) {


            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String bookName = resultSet.getString("bookName");
                int isbnNumber = resultSet.getInt("ISBNNumber");
                String authorName = resultSet.getString("bookAuthor");
                String publisherName = resultSet.getString("bookAuthor");
                String bookType = resultSet.getString("bookType");
                int bookNumber = resultSet.getInt("noOfBooks");

                book = new Book(bookName, isbnNumber, authorName, publisherName, bookType, bookNumber);
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return book;
    }

    @Override
    public boolean issueBook(int employeeId, int bookId, String issueDate, String ScheduledDate) {
        int rows = 0, rows1 = 0, row2 = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement1 = connection
                     .prepareStatement("{call insertIntoTransactions(?,?)}");
             PreparedStatement preparedStatement2 = connection
                     .prepareStatement("update employee set booksIssued = booksIssued+1 where employeeId =?;");
             PreparedStatement preparedStatement = connection
                     .prepareStatement("{call insertIntoTBR(?,?,?,?)}");) {
//			PreparedStatement preparedStatement2 = connection
//                    .prepareStatement("select transactionid from ");

            int f = 0;
            int rand = 0;
            while (f == 0) {
                int max = 10000;
                int min = 20000;
                int range = max - min + 1;
                rand = (int) (Math.random() * range) + min;
//                 preparedStatement1.setInt(1,rand);
//                 ResultSet resultSet1 = preparedStatement1.executeQuery();
//                 if(!resultSet1.next()) {
//                	 f=1;
//                 }
                f = 1;
            }
            preparedStatement1.setInt(1, rand);
            preparedStatement1.setInt(2, employeeId);
            rows1 = preparedStatement1.executeUpdate();

            preparedStatement2.setInt(1, employeeId);
            row2 = preparedStatement2.executeUpdate();

            preparedStatement.setString(3, issueDate);
            preparedStatement.setInt(1, bookId);
            preparedStatement.setString(4, ScheduledDate);
            preparedStatement.setInt(2, rand);

            rows = preparedStatement.executeUpdate();

            System.out.println(rows);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rows > 0 && rows1 > 0 && row2 > 0;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms",
                "root", pass);

             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM book");) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("bookId");
                String bookName = resultSet.getString("bookName");
                int isbnNumber = resultSet.getInt("ISBNNumber");
                String authorName = resultSet.getString("bookAuthor");
                String publisherName = resultSet.getString("bookAuthor");
                String bookType = resultSet.getString("bookType");
                int bookNumber = resultSet.getInt("noOfBooks");
                bookList.add(new Book(bookName, isbnNumber, authorName, publisherName, bookType, bookNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public String checkReturnDate(int empID, int bookId) {
        StringBuilder sb = new StringBuilder();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT returnDate FROM tbr INNER JOIN transactions using(transactionID) " +
                             "WHERE bookId = ? AND employeeID = ?")) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, empID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                java.sql.Date date = resultSet.getDate("returnDate");
                sb.append(empID);
                sb.append(" ");
                sb.append(bookId);
                sb.append(" ");
                sb.append(date.toString());
                sb.append(" ");
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return sb.toString();
    }

    @Override
    public boolean returnBook(int transactionID) {
        int r1 = 0;
        boolean r2 = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass);
             PreparedStatement preparedStatement = connection
                     .prepareStatement("UPDATE tbr SET returnDate=NOW() WHERE transactionID = ?")) {
            preparedStatement.setInt(1, transactionID);
            r1 = preparedStatement.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * from tbr where transactionId = ?");
            preparedStatement2.setInt(1, transactionID);
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            int bookId = 0;
            if (resultSet2.next()) {
                bookId = resultSet2.getInt("bookId");
            }

            if (bookId > 0) {
                r2 = calculateFine(transactionID, bookId) > 0.0;
            }

            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE book SET noOfBooks = noOfBooks + 1 WHERE "
                    + "bookID = ?");
            preparedStatement3.setInt(1, bookId);
            preparedStatement3.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r1 > 0.0 && r2;
    }

    private double calculateFine(int transactionId, int bookID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms", "root", pass)) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT issueDate, scheduleReturn FROM tbr where transactionId = ?");
            preparedStatement.setInt(1, transactionId);
            ResultSet resultSet = preparedStatement.executeQuery();

            java.sql.Date issueDate = resultSet.getDate("issueDate");
            java.sql.Date returnDate = resultSet.getDate("scheduledReturn");

            PreparedStatement diff = connection.prepareStatement("SELECT DATEDIFF(?, ?) AS diff");
            diff.setString(1, String.valueOf(issueDate));
            diff.setString(2, String.valueOf(returnDate));
            ResultSet days_rs = diff.executeQuery();

            int days = -1;
            if (days_rs.next()) {
                days = days_rs.getInt("diff");
            }

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT bookType from book where " +
                    "bookId = ?");
            preparedStatement1.setInt(1, bookID);
            ResultSet rs = preparedStatement1.executeQuery();
            String bookType = null;
            if (rs.next()) {
                bookType = rs.getString("bookType");
            }

            if (days > 7)   {
                switch (Objects.requireNonNull(bookType)) {
                    case "Data Analytics":
                        return 5 * (days - 7);
                    case "Technology":
                        return 6 * (days - 7);
                    case "Management":
                        return 7 * (days - 7);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
