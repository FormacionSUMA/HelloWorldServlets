package es.github.jpm33.helloWorld.web.servlets;

import es.github.jpm33.helloWorld.domain.beans.UserBean;
import es.github.jpm33.helloWorld.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/login")
public class LoginServlet extends AbstractServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class.getSimpleName());

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

//            printRequest(req);
            String fUsernamee = req.getParameter("un");
            String fPassword = req.getParameter("pw");

            logger.info("POST[un] = " + fUsernamee);
            logger.info("POST[pw] = " + fPassword);

            UserBean user = UserService.login(new UserBean(fUsernamee, fPassword));
            if (user.isLoginValid()) {
                req.getSession(true).setAttribute("currentSessionUser", user);
                logger.info("Login OK");
            }
            else {
                logger.info("Login KO para " + user);
            }

            resp.sendRedirect("index.jsp");

        } catch (Throwable theException) {
            System.err.println(theException);
        }
    }
}
