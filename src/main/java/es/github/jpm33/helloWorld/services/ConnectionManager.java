package es.github.jpm33.helloWorld.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class ConnectionManager {

    private static Logger logger = Logger.getLogger(ConnectionManager.class.getName());
    private static ConfigurationService config = new ConfigurationService();

    public static Connection getConnection() {
        try {
            URI uri = new URI(System.getenv("CLEARDB_DATABASE_URL") == null ? config.getValues().getProperty("jdbc_url") :
                                                                                    System.getenv("CLEARDB_DATABASE_URL"));
            ConeectionParams params = new ConeectionParams(uri);

            Class.forName(config.getValues().getProperty("jdbc_driver"));
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

    public ConeectionParams(URI uri) {
        username = uri.getUserInfo().split(":")[0];
        password = uri.getUserInfo().split(":")[1];
        url = "jdbc:mysql://" + uri.getHost() + uri.getPath();
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
}