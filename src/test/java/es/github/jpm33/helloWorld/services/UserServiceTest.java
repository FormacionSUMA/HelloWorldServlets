package es.github.jpm33.helloWorld.services;

import es.github.jpm33.helloWorld.AbstractTest;
import es.github.jpm33.helloWorld.domain.beans.UserBean;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest extends AbstractTest {

    @Test
    public void loginKO() {
        UserBean user = UserService.login(new UserBean("", ""));

        assertFalse("El login sin usuario y password ha devueltro TRUE, algo va mal.", user.isLoginValid());
        assertNull("Vaya, para un usuario NO LOGEADO se esperaba fullName == null.", user.getFullName());
        assertNull("Vaya, para un usuario NO LOGEADO se esperaba createdAt == null.", user.getCreatedAt());
        assertEquals("Vaya, para un usuario NO LOGEADO se esperaba id == 0.", 0, user.getId());
    }

    @Test
    public void loginOK() {
        UserBean user = UserService.login(new UserBean("pepe", "1234"));

        assertTrue("Vaya, se esoera que pepe/1234 fueran unas crredenciales correctas para login.", user.isLoginValid());
        assertNotNull("Vaya, para un usuario LOGEADO se esperaba fullName <> null.", user.getFullName());
        assertNotNull("Vaya, para un usuario LOGEADO se esperaba createdAt <> null.", user.getCreatedAt());
        assertNotEquals("Vaya, para un usuario LOGEADO se esperaba id > 0.", 0, user.getId());
    }

}
