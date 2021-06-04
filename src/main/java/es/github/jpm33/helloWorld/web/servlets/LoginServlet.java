package es.github.jpm33.helloWorld.web.servlets;

import es.github.jpm33.helloWorld.domain.beans.UserBean;
import es.github.jpm33.helloWorld.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            UserBean user = new UserBean()
                    .setUserName(req.getParameter("un"))
                    .setPassword(req.getParameter("pw"));

            if (UserService.login(user).isValid()) {
                req.getSession(true).setAttribute("currentSessionUser", user);
                logger.info("!! Login OK !!");
            }

            resp.sendRedirect("index.jsp");

        } catch (Throwable theException) {
            System.err.println(theException);
        }
    }
}
