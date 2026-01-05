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

@WebServlet("/JdbcServlet")
public class JdbcServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet JDBC</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet JDBC Example</h1>");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cshea",
                    "root",
                    "");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM csheawp");

            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getObject(1) + "</td>");
                out.println("<td>" + rs.getObject(2) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.println("</body></html>");
        out.close();
    }
}
