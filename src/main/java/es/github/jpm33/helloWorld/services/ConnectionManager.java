package es.github.jpm33.helloWorld.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class ConnectionManager {

    private static Logger logger = Logger.getLogger(ConnectionManager.class.getSimpleName());

    public static Connection getConnection() {
        try {
            ConeectionParams params;
            Properties props = new ConfigurationService().getValues();

            if ("org.h2.Driver".equals(props.getProperty("jdbc_driver"))) {
                params = new ConeectionParams();              // testing
                params.setUrl(props.getProperty("jdbc_url")); // leer jdbc_url del fichero test.properties
                params.setUsername("sa");
                params.setPassword("");
            }
            else {
                URI uri = new URI(System.getenv("CLEARDB_DATABASE_URL") == null ? props.getProperty("jdbc_url") :
                                                                                        System.getenv("CLEARDB_DATABASE_URL"));
                params = new ConeectionParams(uri); // producción
            }

            Class.forName(props.getProperty("jdbc_driver"));
            return DriverManager.getConnection(params.getUrl(), params.getUsername(), params.getPassword());

        } catch (ClassNotFoundException | URISyntaxException | SQLException ex) {
            logger.log(SEVERE, ex.getMessage(), ex);
            ex.printStackTrace();
        }

        return null;
    }
}

class ConeectionParams {

    private String username;
    private String password;
    private String url;

    public ConeectionParams() {

    }

    public ConeectionParams(URI uri) {
        username = uri.getUserInfo().split(":")[0];
        password = uri.getUserInfo().split(":")[1];
        url = "jdbc:mysql://" + uri.getHost() + uri.getPath() + "?loggerLevel=DEBUG";
    }

    public String getUsername() {
        return username;
    }

    public ConeectionParams setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ConeectionParams setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ConeectionParams setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConeectionParams.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("url='" + url + "'")
                .toString();
    }
}