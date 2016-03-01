package feedback;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SayWhat extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException{
       
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String comments = request.getParameter("comments");

        HttpSession session = request.getSession();
        Reporter reporter = (Reporter) session.getAttribute("reporter");
        if (reporter == null)
            reporter = new Reporter();
        
        reporter.setEMAIL(email);
        reporter.setNAME(name);
        reporter.setCOMMENTS(comments);

        ReporterIO.addRecord(reporter,
        //   "/webs/web_t3/t3candid/html/feedback/choke.txt");
        "../webapps/intelli-j_template/feedback.txt");

        session.setAttribute("reporter", reporter);

        RequestDispatcher dispatcher =
                     getServletContext().getRequestDispatcher(
                            "/show_feedback.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {
        doGet(request, response);
    }

}