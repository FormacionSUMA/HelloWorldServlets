package es.github.jpm33.helloWorld.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigurationServiceTest {

    private ConfigurationService service = new ConfigurationService("test.properties");

    @Test
    public void cargarDatosOK() {
        assertEquals("Vaya, se espera leer 2 propiedades con getValues().", 2, service.getValues().size());
    }
}
