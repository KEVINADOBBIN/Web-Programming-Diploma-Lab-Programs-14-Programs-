import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RandomGreetingServlet extends HttpServlet {

    private static final String[] GREETINGS = {
        "Good Morning",
        "Good Night",
        "How are you?",
        "Good Evening",
        "See you"
    };

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Random r = new Random();
        String msg = GREETINGS[r.nextInt(GREETINGS.length)];

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Random Greeting Servlet</h1>");
        out.println("<h2>" + msg + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
