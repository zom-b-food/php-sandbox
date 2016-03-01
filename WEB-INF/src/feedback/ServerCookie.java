package feedback;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet. * ;
import java.io. * ;
import java.util.Enumeration;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

public class ServerCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //
        // Get client's stuff
        //
        String clientIP = request.getRemoteAddr();
        String clientHost = request.getRemoteHost();
        String localName  = request.getLocalName();
        Enumeration clientL = request.getLocales();


        try {
            PrintWriter out = new PrintWriter(new FileWriter("/home/toshi/public_html/ui-design-engineering.com/sources/ip.txt"));
	        //  /home/toshi/public_html/ui-design-engineering.com/sources/ip.txt
	        //  C:/tomcat-6/webapps/am_2012/sources/ip.txt
            out.println("IP  : " + clientIP);
            out.println("Host: " + clientHost);
            out.println("Local Name: " + localName);
            out.println("Locales: " + clientL);

            out.flush();
            out.close();

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(
                            "/");
            dispatcher.forward(request, response);

        } catch (IOException e) {

            e.printStackTrace();
        }


    }
}