package com.stement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step:1 - Load and Register a Driver
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded successfully.");

        // Step:2 - Create Connection Object
        //String url = "jdbc:postgresql://localhost:5432/postgres";
        String url = "jdbc:postgresql://localhost:5432/Dev";
        String user = "postgres";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user,password);
        System.out.println("Connected to database successfully.");

        // Step:3 - Create Statement object
        Statement statement = connection.createStatement();

        // Step:4 - Execute a statement with select query
        String sql = "INSERT INTO student (sid, sname, marks) VALUES (1, 'Balaji', 33)";
        int executed = statement.executeUpdate(sql);
        System.out.println("Inserted " + executed + " record(s) in table student in database successfully.");

        // Step:6 - Close the connection
        statement.close();
        connection.close();
        System.out.println("Connection closed successfully.");
    }

}
