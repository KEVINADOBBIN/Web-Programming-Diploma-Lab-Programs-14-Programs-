import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String regno = request.getParameter("Regno");
        String name = request.getParameter("Name");
        String age = request.getParameter("Age");
        String dob = request.getParameter("DOB");
        String add1 = request.getParameter("Add1");
        String add2 = request.getParameter("Add2");
        String add3 = request.getParameter("Add3");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/minipro",
                    "root",
                    "");

            stmt = con.createStatement();

            stmt.executeUpdate(
                "INSERT INTO tbminipro VALUES('" + regno + "','" + name + "','" +
                age + "','" + dob + "','" + add1 + "','" + add2 + "','" + add3 + "')"
            );

            rs = stmt.executeQuery("SELECT * FROM tbminipro");

            out.println("<html><body>");
            out.println("<h2>Student Records</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>RegNo</th><th>Name</th><th>Age</th><th>DOB</th><th>Permanent</th><th>Residential</th><th>Email</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= 7; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }
                out.println("</tr>");
            }

            out.println("</table></body></html>");

        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {}
        }
        out.close();
    }
}
