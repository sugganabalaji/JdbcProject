package com.prepared.stement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecord {

        public static void main(String[] args) {
            // Database credentials
            String url = "jdbc:postgresql://localhost:5432/Dev";
            String user = "postgres";
            String password = "root";
            String sql = "INSERT INTO student (sid, sname, marks) VALUES (?, ?, ?)";

            try {
                // Step:1 - Load and Register a Driver
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver loaded successfully.");

                // Step:2 - Get user input with validation
                Scanner sc = new Scanner(System.in);

                System.out.print("Please enter your SID: ");
                int sid = sc.nextInt();
                sc.nextLine();

                System.out.print("Please enter your Student Name: ");
                String sName = sc.nextLine().trim();

                // Validate student name is not empty
                if (sName.isEmpty()) {
                    System.out.println("Error: Student name cannot be empty.");
                    sc.close();
                    return;
                }

                System.out.print("Please enter your marks: ");
                int marks = sc.nextInt();

                // Validate marks are within reasonable range
                if (marks < 0 || marks > 100) {
                    System.out.println("Error: Marks must be between 0 and 100.");
                    sc.close();
                    return;
                }

                sc.close(); // Close scanner after use

                // Step:3 - Create Connection and Prepared Statement (using try-with-resources)
                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement ps = connection.prepareStatement(sql)) {

                    System.out.println("Connected to database successfully.");

                    // Step:4 - Set parameters and execute
                    ps.setInt(1, sid);
                    ps.setString(2, sName);
                    ps.setInt(3, marks);

                    int rowsInserted = ps.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Inserted " + rowsInserted + " record(s) successfully.");
                    }
                }
                // Connection and PreparedStatement are automatically closed here
                System.out.println("Connection closed successfully.");
            } catch (Exception e) {
                System.err.println("An unexpected error occurred.");
                e.printStackTrace();
            }
        }

}
