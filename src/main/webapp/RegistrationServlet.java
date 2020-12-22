import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/re")
public class RegistrationServlet extends HttpServlet {
    InMemory inMemory = new InMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (name == null || login == null || password == null) {
            resp.getWriter().print("Vi vveli ne vse danni dla registracii. Try again.");
        } else {
            if (name.length() <= 2 || password.length() < 5) {
                if (name.length() <= 2) {
                    resp.getWriter().print("Ne correktnii dannii.Name dolzen soderzat bolshe 2 simvolov.");
                } else {
                    resp.getWriter().print("Ne correktnii dannii.Password dolzen soderzat bolshe 5 simvolov.");
                }
            } else {
                if (inMemory.uniqPerson(new Person(name, login, password))) {
                    resp.getWriter().print("User s takim loginom uze est.Poprobyite esche.");
                } else {
                    inMemory.AddToMemory(new Person(name, login, password));
                    resp.getWriter().print("Sucsess. You are registered");
                }

            }
        }
    }
}