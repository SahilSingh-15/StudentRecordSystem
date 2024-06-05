package studentRecordSystem;

import student_Record_System.StudentManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set deletionSuccess attribute to avoid NullPointerException in JSP
        request.setAttribute("deletionSuccess", null);

        // Forward the request to the delete.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student ID from request parameter
        int studentId = Integer.parseInt(request.getParameter("id"));
        System.out.println("Student ID to delete: " + studentId); // Print the student ID

        // Delete the student record from the database
        StudentManager studentManager = new StudentManager();
        boolean deletionSuccess = studentManager.deleteStudent(studentId);

        // Set deletion status as an attribute in the request
        request.setAttribute("deletionSuccess", deletionSuccess);

        // Forward the request to the delete.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        dispatcher.forward(request, response);
    }
}
