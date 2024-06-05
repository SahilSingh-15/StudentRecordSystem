<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Student</title>
    <link rel="stylesheet" href="insertStyles.css"> 
</head>
<body>

<div class="form-holder">
    <form action="InsertStudentServlet" method="post" class="form-content">
        <div class="form-items">
            <h3>Insert Student</h3>
            
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
            
            <input type="submit" value="Submit">
            
            
        </div>
    </form>
    
    <div style="text-align: center;">
        <% if (request.getAttribute("isSuccess") != null && (boolean) request.getAttribute("isSuccess")) { %>
            <p style="color: green;">Student inserted successfully!</p>
        <% } else if (request.getAttribute("isSuccess") != null && !(boolean) request.getAttribute("isSuccess")) { %>
            <p style="color: red;">Failed to insert student.</p>
        <% } %>
    </div>
</div>

</body>
</html>
