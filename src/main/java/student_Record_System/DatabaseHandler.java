package student_Record_System;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    private static Connection connection;
    private static final String JDBC_URL = "jdbc:sqlite:";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                System.out.println("Connecting to the database...");
                createDatabaseFile(); // Create the database file if it doesn't exist
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(JDBC_URL + DatabaseHandler.class.getResource("/").getPath() + "students1.db");
                System.out.println("Database connection established.");
                createStudentTable(); // Create the student table if it doesn't exist
            } catch (Exception e) {
                System.err.println("Error connecting to the database:");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection:");
            e.printStackTrace();
        }
    }

    public static void createStudentTable() {
        try {
            System.out.println("Creating student table...");
            Statement statement = getConnection().createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "regNo TEXT NOT NULL, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "groupNo INTEGER NOT NULL, " +
                    "grade INTEGER NOT NULL)");
            statement.close();
            System.out.println("Student table created.");
        } catch (SQLException e) {
            System.err.println("Error creating student table:");
            e.printStackTrace();
        }
    }
    
    public static void createDatabaseFile() {
    	System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        File databaseFile = new File("students.db");
        if (!databaseFile.exists()) {
            try {
                if (databaseFile.createNewFile()) {
                    System.out.println("Database file created successfully.");
                } else {
                    System.out.println("Failed to create database file.");
                }
            } catch (Exception e) {
                System.err.println("Error creating database file:");
                e.printStackTrace();
            }
        } else {
            System.out.println("Database file already exists.");
        }
    }
}
