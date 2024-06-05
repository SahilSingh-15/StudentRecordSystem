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
import javax.servlet.RequestDispatcher;

@WebServlet("/ViewAllStudentsServlet")
public class ViewAllStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentManager studentManager = new StudentManager();
        ResultSet resultSet = studentManager.getAllStudents();

        // Debugging: Check if the resultSet is populated
        try {
            if (resultSet != null && resultSet.next()) {
                resultSet.beforeFirst(); // Move cursor to the start
                System.out.println("Students found in the database.");
            } else {
                System.out.println("No students found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("students", resultSet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAll.jsp");
        dispatcher.forward(request, response);
    }
}
