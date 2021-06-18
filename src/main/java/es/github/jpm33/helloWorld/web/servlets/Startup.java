package es.github.jpm33.helloWorld.web.servlets;

import javax.servlet.annotation.WebServlet;
import java.util.logging.Logger;

@WebServlet(value = "/Startup")
public class  Startup extends AbstractServlet {
    static {
        String path = Startup.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);

        Logger.getLogger(Startup.class.getName()).info("Carga la configuración del fichero logging.properties localizado en el CLASSPATH.");
        Logger.getLogger(Startup.class.getName()).info(path);
    }
}
