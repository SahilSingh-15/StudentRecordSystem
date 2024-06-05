package studentRecordSystem;

import student_Record_System.StudentManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search keyword from the request
        String keyword = request.getParameter("keyword");

        // Create an instance of StudentManager to interact with the database
        StudentManager studentManager = new StudentManager();

        // Search for students matching the keyword
        ResultSet resultSet = studentManager.searchStudent(keyword);

        // Set the search results as an attribute in the request
        request.setAttribute("students", resultSet);

        // Forward the request to the search.jsp page to display the results
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
