package es.github.jpm33.helloWorld;

import java.util.logging.LogManager;

public abstract class AbstractTest {
    static {
        //
        // Ref: https://www.logicbig.com/tutorials/core-java-tutorial/java-se-api/util-formatter.html
        //
        // System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT [%4$-7s] %3$s - %5$s %n");
//        System.setProperty(".level", "OFF");

        //System.setProperty("jdbc_driver", "org.h2.Driver");
        // Indicar donde está la configuración de la aplicacion (debe estar en el CLASSPATH)
        System.setProperty("configFile", "test.properties");

//        System.setProperty("handlers", "java.util.logging.ConsoleHandler");
//        System.setProperty(".level", "OFF");
//        System.setProperty("java.util.logging.ConsoleHandler.level", "OFF");
//        System.setProperty("java.util.logging.ConsoleHandler.formatter", "java.util.logging.SimpleFormatter");
//        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        // Deshabilitar logs
        LogManager.getLogManager().reset();

    }
}
