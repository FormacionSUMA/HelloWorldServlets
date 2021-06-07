package es.github.jpm33.helloWorld.web.servlets;

import javax.servlet.annotation.WebServlet;
import java.util.logging.Logger;

@WebServlet(value = "/Startup")
public class  Startup extends AbstractServlet {
//    private static Logger LOGGER;
    static {
        String path = Startup.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
//        LOGGER = L
        Logger.getLogger(Startup.class.getName()).info("Carga la configuración del CLASSPATH del fichero logging.properties");
    }
}
