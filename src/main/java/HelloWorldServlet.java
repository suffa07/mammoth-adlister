import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    /*public static void main(String[] args) {
        System.out.println("1, 2, 3, 4");
        String url = "/hello";
        switch (url) {
            case "/hello:
                helloServlet.doGet();
                break;
            case "/count":
                counterServlet.doGet();
        }
    }*/

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        writer.println("</head>");
        writer.println("<body>");
        String name = req.getParameter("name");
        if (name == null) {
            writer.println("<h1>Hello world</h1>");
        } else {
            writer.printf("<h1>Hello %s</h1>", name);
        }
        writer.println("</body>");
        writer.println("</html>");

        /*String aCase = req.getParameter("case");  // if case is not present, it will be null
        if ("upper".equalsIgnoreCase(aCase)) {
            output.println("<h1>Hello world</h1>".toUpperCase());
        } else if ("lower".equalsIgnoreCase(aCase)) {
            output.println("<h1>Hello world</h1>".toLowerCase());
        } else {
            output.println("<h1>Hello world</h1>");
        }*/
    }
}
