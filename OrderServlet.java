import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String userName = req.getParameter("UserName");

        int item1 = 0, item2 = 0, item3 = 0, item4 = 0;
        int price1 = 20, price2 = 40, price3 = 30, price4 = 70;

        if (req.getParameter("option1") != null)
            item1 = Integer.parseInt(req.getParameter("val1"));

        if (req.getParameter("option2") != null)
            item2 = Integer.parseInt(req.getParameter("val2"));

        if (req.getParameter("option3") != null)
            item3 = Integer.parseInt(req.getParameter("val3"));

        if (req.getParameter("option4") != null)
            item4 = Integer.parseInt(req.getParameter("val4"));

        int total1 = item1 * price1;
        int total2 = item2 * price2;
        int total3 = item3 * price3;
        int total4 = item4 * price4;

        double total = total1 + total2 + total3 + total4;
        total += (total * 2.0) / 100;

        out.println("<html><body>");
        out.println("<h3>User Name: " + userName + "</h3>");
        out.println("<h3>Ordered Items</h3>");

        out.println("<table border='1'>");
        out.println("<tr><th>Qty</th><th>Price</th><th>Total</th></tr>");
        out.println("<tr><td>" + item1 + "</td><td>" + price1 + "</td><td>" + total1 + "</td></tr>");
        out.println("<tr><td>" + item2 + "</td><td>" + price2 + "</td><td>" + total2 + "</td></tr>");
        out.println("<tr><td>" + item3 + "</td><td>" + price3 + "</td><td>" + total3 + "</td></tr>");
        out.println("<tr><td>" + item4 + "</td><td>" + price4 + "</td><td>" + total4 + "</td></tr>");
        out.println("</table>");

        out.println("<br><b>Total Bill (Including 2% Sales Tax): Rs." + total + "</b>");
        out.println("</body></html>");
    }
}
