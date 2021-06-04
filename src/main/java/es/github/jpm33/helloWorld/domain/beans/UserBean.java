package es.github.jpm33.helloWorld.domain.beans;

import java.util.Objects;

public class UserBean {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    public boolean valid;

    public UserBean() {
    }

    public String getUserName() {
        return userName;
    }

    public UserBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserBean setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBean setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isValid() {
        return valid;
    }

    public UserBean setValid(boolean valid) {
        this.valid = valid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBean)) return false;
        UserBean userBean = (UserBean) o;
        return isValid() == userBean.isValid() && Objects.equals(getUserName(), userBean.getUserName()) && Objects.equals(getPassword(), userBean.getPassword()) && Objects.equals(getFirstName(), userBean.getFirstName()) && Objects.equals(getLastName(), userBean.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), getFirstName(), getLastName(), isValid());
    }
}
