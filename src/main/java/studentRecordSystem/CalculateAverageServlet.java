package studentRecordSystem;

import student_Record_System.StudentManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateAverageServlet")
public class CalculateAverageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentManager studentManager = new StudentManager();
        double averageGrade = studentManager.calculateAverageGrade();

        // Redirect back to index.html with the average grade
        response.sendRedirect("index.html?averageGrade=" + averageGrade);
    }
}