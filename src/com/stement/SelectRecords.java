package com.stement;

import java.sql.*;

public class SelectRecords {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step:1 - Load and Register a Driver
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded successfully.");

        // Step:2 - Create Connection Object
        String url = "jdbc:postgresql://localhost:5432/Dev";
        String user = "postgres";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user,password);
        System.out.println("Connected to database successfully.");

        // Step:3 - Create Statement object
        Statement statement = connection.createStatement();

        // Step:4 - Execute a statement with select query
        String sql = "SELECT sid, sname, marks FROM student ORDER BY sid ASC";
        ResultSet resultSet = statement.executeQuery(sql);

        // Step:5 - Process Results
        while (resultSet.next()) {
            int sid = resultSet.getInt("sid");
            String sname = resultSet.getString("sname");
            int marks = resultSet.getInt("marks");

            System.out.println(sid + " " + sname + " " + marks);
        }

        // Step:6 - Close the connection
        statement.close();
        connection.close();
        System.out.println("Connection closed successfully.");
    }

}
