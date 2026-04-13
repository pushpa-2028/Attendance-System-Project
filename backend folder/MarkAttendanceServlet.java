import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/markAttendance")
public class MarkAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String status = req.getParameter("status");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(student_id, date, status) VALUES (?, CURDATE(), ?)"
            );

            ps.setInt(1, studentId);
            ps.setString(2, status);
            ps.executeUpdate();

            res.sendRedirect("dashboard.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}