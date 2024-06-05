<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Student</title>
  <link rel="stylesheet" href="searchStyles.css">
</head>
<body>

<div class="form-holder">
    <form action="SearchStudentServlet" method="get" class="form-content">
        <div class="form-items">
            <h3>Search Student</h3>
            
            <!-- Input field to enter search keyword -->
            <label for="keyword">Keyword:</label><br>
            <input type="text" id="keyword" name="keyword" required><br>
            
            <input type="submit" value="Search">
        </div>
    </form>
    
    <div style="text-align: center;">
        <% if (request.getAttribute("students") != null) { %>
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
                    while (students.next()) { %>
                        <tr>
                            <td><%= students.getInt("id") %></td>
                            <td><%= students.getString("regNo") %></td>
                            <td><%= students.getString("name") %></td>
                            <td><%= students.getInt("age") %></td>
                            <td><%= students.getInt("groupNo") %></td>
                            <td><%= students.getInt("grade") %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</div>

</body>
</html>
