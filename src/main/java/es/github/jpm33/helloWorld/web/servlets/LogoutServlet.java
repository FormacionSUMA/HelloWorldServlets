package es.github.jpm33.helloWorld.web.servlets;

import es.github.jpm33.helloWorld.domain.beans.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/logout")
public class LogoutServlet extends AbstractServlet  {

    private static Logger logger = Logger.getLogger(LogoutServlet.class.getSimpleName());

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean user = (UserBean) req.getSession(true).getAttribute("currentSessionUser");
        if (user == null) {
            logger.warning("No hay sesion que cerrar!");
        }
        else {
            logger.info(String.format("Cerrando la sesion del usuario '%s'.", user.getLogin()));
            req.getSession(true).removeAttribute("currentSessionUser");
        }

        resp.sendRedirect("index.jsp");
    }
}
