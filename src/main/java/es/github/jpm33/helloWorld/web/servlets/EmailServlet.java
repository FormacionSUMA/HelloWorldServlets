package es.github.jpm33.helloWorld.web.servlets;

import es.github.jpm33.helloWorld.utils.EmailUtility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/email")
public class EmailServlet extends AbstractServlet {

    private static Logger logger = Logger.getLogger(EmailServlet.class.getSimpleName());

    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("smtp.host");
        port = context.getInitParameter("smtp.port");
        user = context.getInitParameter("smtp.user");
        pass = context.getInitParameter("smtp.pass");

        logger.info(host);
        logger.info(port);
        logger.info(user);
        logger.info(pass);

    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("recipient");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        String resultMessage = "";

        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            req.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/email-result.jsp").forward(req, resp);
        }
    }
}
