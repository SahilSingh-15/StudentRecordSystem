<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student</title>
    <link rel="stylesheet" href="deleteStyles.css">
</head>
<body>

<div class="form-holder">
    <form action="DeleteStudentServlet" method="post" class="form-content">
        <div class="form-items">
            <h3>Delete Student Record</h3>
            
            <% 
                Boolean deletionSuccess = (Boolean) request.getAttribute("deletionSuccess");
                if (deletionSuccess != null) {
                    if (deletionSuccess) {
            %>
                <p style="color: green;">Student record deleted successfully.</p>
            <% 
                    } else { 
            %>
                <p style="color: red;">Failed to delete student record.</p>
            <% 
                    }
                }
            %>
            
            <label for="studentId">Enter Student ID:</label>
            <input type="text" id="studentId" name="id" required>
            <input type="submit" value="Delete">
        </div>
    </form>
</div>

</body>
</html>
