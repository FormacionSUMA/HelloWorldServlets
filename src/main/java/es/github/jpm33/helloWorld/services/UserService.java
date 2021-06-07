package es.github.jpm33.helloWorld.services;

import es.github.jpm33.helloWorld.domain.beans.UserBean;
import es.github.jpm33.helloWorld.web.servlets.LoginServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static Logger logger = Logger.getLogger(UserService.class.getName());

    public static UserBean getUser(String login) {
        try (Connection con = ConnectionManager.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT id, login, fullname, created_at, active FROM usuarios WHERE login = ? LIMIT 1");
            ps.setString(1, login);

            logger.info(String.format("executeQuery :: %s", ps));
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                return new UserBean()
                        .setId(result.getInt(1))
                        .setLogin(login)
                        .setPassword(null)
                        .setFullName(result.getString(3))
                        .setCreatedAt(result.getDate(4))
                        .setActive(result.getBoolean(5));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static UserBean login(UserBean user) {
//        UserBean usu = new UserBean();
        try (Connection con = ConnectionManager.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT login, password FROM usuarios WHERE login = ? AND password = ? AND active IS TRUE LIMIT 1");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());

            logger.info(String.format("executeQuery :: %s", ps));
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                user = getUser(user.getLogin()); // refresco todos los datos
                user.setLoginValid(true);        // LoginValid => TRUE
                logger.info(user.toString());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}
