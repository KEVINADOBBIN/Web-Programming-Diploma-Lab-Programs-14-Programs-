import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String songName = req.getParameter("SongName");
        String composer = req.getParameter("CName");
        String singer = req.getParameter("Singer");

        // File path inside Codespace
        String songFile = "/tmp/song.txt";

        try {
            FileWriter fw = new FileWriter(songFile, true);
            fw.write(songName + "#" + singer + "##" + composer + "\n");
            fw.close();
        } catch (Exception e) {
            out.println("Error: " + e);
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");

        out.println("<h4>The contents are written to the file: " + songFile + "</h4>");
        out.println("<h4>The Most Popular Songs are:</h4>");
        out.println("<h3>SongName # Singer ## Composer</h3>");

        FileReader fr = new FileReader(songFile);
        int ch;
        while ((ch = fr.read()) != -1) {
            out.print((char) ch);
        }
        fr.close();

        out.println("</body></html>");
    }
}
