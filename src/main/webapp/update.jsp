<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <link rel="stylesheet" href="updateStyles.css"> 
</head>
<body>

<div class="form-holder">
    <form action="UpdateStudentServlet" method="post" class="form-content">
        <div class="form-items">
            <h3>Update Student</h3>
            
            <!-- Input fields to update student details -->
            <label for="id">Student ID:</label><br>
            <input type="number" id="id" name="id" required><br>
            
            <label for="regNo">Registration Number:</label><br>
            <input type="text" id="regNo" name="regNo" required><br>
            
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" required><br>
            
            <label for="age">Age:</label><br>
            <input type="number" id="age" name="age" required><br>
            
            <label for="groupNo">Group Number:</label><br>
            <input type="number" id="groupNo" name="groupNo" required><br>
            
            <label for="grade">Grade:</label><br>
            <input type="number" id="grade" name="grade" min="0" max="100" required><br>
            
            <input type="submit" value="Update">
        </div>
    </form>
    
    <div style="text-align: center;">
        <% if (request.getAttribute("isSuccess") != null && (boolean) request.getAttribute("isSuccess")) { %>
            <p style="color: green;">Student updated successfully!</p>
        <% } else if (request.getAttribute("isSuccess") != null && !(boolean) request.getAttribute("isSuccess")) { %>
            <p style="color: red;">Failed to update student.</p>
        <% } %>
    </div>
</div>

</body>
</html>
