package es.github.jpm33.helloWorld.domain.beans;

import java.sql.Date;
import java.util.Objects;
import java.util.StringJoiner;

//
// Mapea la tabla usuario
//
public class UserBean {

    // Campos de BD
    private long id;
    private String login;
    private String password;
    private String fullName;
    private Date createdAt;
    private boolean active;

    // Campo extra
    private boolean loginValid = false;

    public UserBean(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getStatus() {
        return active ? "ACTIVO": "INACTIVO";
    }

    // -- startOf: getters & setters --

    public long getId() {
        return id;
    }

    public UserBean setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserBean setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserBean setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public UserBean setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserBean setActive(boolean active) {
        this.active = active;
        return this;
    }

    public boolean isLoginValid() {
        return loginValid;
    }

    public UserBean setLoginValid(boolean loginValid) {
        this.loginValid = loginValid;
        return this;
    }

    // -- endOf getters & setters --

=======
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
        return getId() == userBean.getId() && isActive() == userBean.isActive() && isLoginValid() == userBean.isLoginValid() && Objects.equals(getLogin(), userBean.getLogin()) && Objects.equals(getPassword(), userBean.getPassword()) && Objects.equals(getFullName(), userBean.getFullName()) && Objects.equals(getCreatedAt(), userBean.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getFullName(), getCreatedAt(), isActive(), isLoginValid());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserBean.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("login='" + login + "'")
                //.add("password='" + password + "'")
                .add("password='********'")
                .add("fullName='" + fullName + "'")
                .add("createdAt=" + createdAt)
                .add("active=" + active)
                .add("loginValid=" + loginValid)
                .toString();
    }
}
