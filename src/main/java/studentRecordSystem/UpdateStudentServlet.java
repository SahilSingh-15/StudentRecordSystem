package studentRecordSystem;

import student_Record_System.StudentManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String regNo = request.getParameter("regNo");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int groupNo = Integer.parseInt(request.getParameter("groupNo"));
        int grade = Integer.parseInt(request.getParameter("grade"));

        // Create an instance of StudentManager to interact with the database
        StudentManager studentManager = new StudentManager();

        // Update student record in the database
        boolean isSuccess = studentManager.updateStudent(id, regNo, name, age, groupNo, grade);

        // Set an attribute in the request to indicate success or failure
        request.setAttribute("isSuccess", isSuccess);

        // Forward the request to the update.jsp page
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
