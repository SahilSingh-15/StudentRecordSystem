<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Students</title>
    <link rel="stylesheet" href="viewAllStyles.css">
</head>
<body>

<div class="form-holder">
    <div style="text-align: center;">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Registration Number</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Group Number</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
                <% 
                ResultSet students = (ResultSet) request.getAttribute("students");
                if (students != null) {
                    try {
                        while (students.next()) { %>
                            <tr>
                                <td><%= students.getInt("id") %></td>
                                <td><%= students.getString("regNo") %></td>
                                <td><%= students.getString("name") %></td>
                                <td><%= students.getInt("age") %></td>
                                <td><%= students.getInt("groupNo") %></td>
                                <td><%= students.getInt("grade") %></td>
                            </tr>
                        <% }
                        students.close(); // Close the ResultSet
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else { %>
                    <tr>
                        <td colspan="6">No students found</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
