package es.github.jpm33.helloWorld.services;

import es.github.jpm33.helloWorld.web.servlets.ReportServlet;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class ConfigurationService {

    private static Logger logger = Logger.getLogger(ConfigurationService.class.getName());

    private String propFileName;
    private Properties prop;

    public ConfigurationService() {
        this("application.properties");
    }

    public ConfigurationService(String propFileName) {
        this.propFileName = propFileName;
        prop = new Properties();
    }

    public Properties getValues() {
        try(InputStream is = this.getClass().getClassLoader().getResourceAsStream(propFileName)) {
            if (is != null) {
                prop.load(is);;
            } else {
                throw new FileNotFoundException(String.format("Property file '%s' not found in the classpath.", propFileName));
            }
        } catch (Exception ex) {
            logger.log(SEVERE, ex.getMessage(), ex);
        }
        return prop;
    }

    public String getFileName() {
        return propFileName;
    }

    public Properties getProperties() {
        return prop;
    }
}
