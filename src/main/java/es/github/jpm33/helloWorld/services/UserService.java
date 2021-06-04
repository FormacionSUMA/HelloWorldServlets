package es.github.jpm33.helloWorld.services;

import es.github.jpm33.helloWorld.domain.beans.UserBean;

public class UserService {
    public static UserBean login(UserBean user) {
        return user.setValid("admin".equals(user.getUserName()) && "1234".equals(user.getPassword()));
    }
}
