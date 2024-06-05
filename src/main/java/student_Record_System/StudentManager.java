package student_Record_System;

import java.sql.*;

public class StudentManager {
    private Connection connection;

    public StudentManager() {
        connection = DatabaseHandler.getConnection();
    }

    public boolean insertStudent(String regNo, String name, int age, int groupNo, int grade) {
        String query = "INSERT INTO students (regNo, name, age, groupNo, grade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, regNo);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, groupNo);
            preparedStatement.setInt(5, grade);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(int id, String regNo, String name, int age, int groupNo, int grade) {
        String query = "UPDATE students SET regNo=?, name=?, age=?, groupNo=?, grade=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, regNo);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, groupNo);
            preparedStatement.setInt(5, grade);
            preparedStatement.setInt(6, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet searchStudent(String keyword) {
        String query = "SELECT * FROM students WHERE name LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double calculateAverageGrade() {
        String query = "SELECT AVG(grade) AS average FROM students";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return resultSet.getDouble("average");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet getAllStudents() {
        String query = "SELECT * FROM students";
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
