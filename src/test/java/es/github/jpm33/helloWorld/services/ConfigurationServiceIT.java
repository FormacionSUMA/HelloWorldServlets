package es.github.jpm33.helloWorld.services;

import org.junit.Test;

public class ConfigurationServiceIT {

    private ConfigurationService service = new ConfigurationService("test.properties");

    @Test
    public void cargarDatosOK() {
        service.getValues().list(System.out);
    }
}
