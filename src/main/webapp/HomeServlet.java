import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person=(Person) req.getSession().getAttribute("login");
        if(person!=null){
            resp.getWriter().print("Hello "+person.getName());
        }else {
            resp.getWriter().print("Hello Guest");
        }
    }
}
