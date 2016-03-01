package feedback;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServerCookie2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		String clientIP = request.getRemoteAddr();
        String clientHost = request.getRemoteHost();
        String localName  = request.getLocalName();

		HttpSession session = request.getSession();
		Reporter2 reporter2 = (Reporter2) session.getAttribute("reporter2");
		if (reporter2 == null)
			reporter2 = new Reporter2();


		reporter2.setIP(clientIP);
		reporter2.setHOST(clientHost);
		reporter2.setNAME(localName);


		ReporterIO2.addRecord(reporter2,
				"/home/toshi/public_html/ui-design-engineering.com/HHIT/rca.txt");
			// "C:/tomcat-6/webapps/ui-design-engineering/HHIT/rca.txt");

		session.setAttribute("reporter2", reporter2);

		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher(
					"/");
		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}