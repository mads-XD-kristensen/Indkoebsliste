import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = getServletContext();
        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if (sc.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");

            sc.setAttribute("brugerMap", brugerMap);
        }

        if (!((Map<String, String>) sc.getAttribute("brugerMap")).containsKey(navn)) {

            //todo gå til login siden

            request.setAttribute("besked","Opret dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
        }


        if (((Map<String, String>) sc.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            //todo gå til huskelisten

            request.getRequestDispatcher("/WEB-INF/Huskeliste.jsp").forward(request,response);
        }

        //todo gå til login dvs. index siden
        request.setAttribute("besked","din kode var forkert, prøv igen");
       request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
