import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = getServletContext();

        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if (sc.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");
            brugerMap.put("admin", "admin");


            sc.setAttribute("brugerMap", brugerMap);
        }


        if (((Set<String>) sc.getAttribute("aktiveBrugere")) == null) {
            Set<String> aktiveBrugere = new HashSet<>();
            sc.setAttribute("aktiveBrugere", aktiveBrugere);

        }


        if (!(session.getAttribute("besked") == null)) {
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request, response);
        }


        if (!((Map<String, String>) sc.getAttribute("brugerMap")).containsKey(navn)) {


            request.setAttribute("besked", "Opret dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }


        if (((Map<String, String>) sc.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            if (navn.equalsIgnoreCase("admin")) {

                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

            }


            if (!((Set<String>) sc.getAttribute("aktiveBrugere")).contains(navn)) {
                ((Set<String>) sc.getAttribute("aktiveBrugere")).add(navn);

                session.setAttribute("besked", "du er logget ind med navnet: " + navn);
                session.setAttribute("navn", navn);

                request.getRequestDispatcher("/WEB-INF/Huskeliste.jsp").forward(request, response);
            }


        }

        //todo gå til login dvs. index siden
        request.setAttribute("besked", "Noget gik galt, prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
