import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String name = req.getParameter("name");
        String usn = req.getParameter("usn");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name, usn) VALUES (?, ?)"
            );

            ps.setString(1, name);
            ps.setString(2, usn);
            ps.executeUpdate();

            res.sendRedirect("dashboard.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}