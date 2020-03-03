import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OpretServlet", urlPatterns = "/OpretServlet")
public class OpretServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = getServletContext();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        //tjekker om brugnavnet allereder bliver brugt
        if (((Map<String, String>) sc.getAttribute("brugerMap")).containsKey(navn)) {

            request.setAttribute("besked", "Navnet du angav er allerede ibrug");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }
        // opretter en bruger
        ((Map<String, String>) sc.getAttribute("brugerMap")).put(navn, kodeord);

        request.setAttribute("besked", "Du er nu oprettet og er klar til at logge ind");
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
