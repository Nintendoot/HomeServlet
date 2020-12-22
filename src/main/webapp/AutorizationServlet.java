import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/au")
public class AutorizationServlet extends HttpServlet {
    InMemory inMemory=new InMemory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
      if(inMemory.personInMemory(login,password)!=null){
          req.getSession().setAttribute("login",inMemory.personInMemory(login,password));
          resp.getWriter().print("Sucsess!!!Vi voshli v sistemu.");

      }else {
          resp.getWriter().print("Vi ne zaregestrirovani.Proiditi registraciu.");
      }
    }
}
