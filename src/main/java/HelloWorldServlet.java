import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter output = res.getWriter();

        String aCase = req.getParameter("case");  // if case is not present, it will be null
        if ("upper".equalsIgnoreCase(aCase)) {
            output.println("<h1>Hello world</h1>".toUpperCase());
        } else if ("lower".equalsIgnoreCase(aCase)) {
            output.println("<h1>Hello world</h1>".toLowerCase());
        } else {
            output.println("<h1>Hello world</h1>");
        }
    }
}
