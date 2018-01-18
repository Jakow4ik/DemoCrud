package com.democrud;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int phone;

    public User() {
        super();
    }
    public User(int id, String login, String password, String email, int phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone =phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[" + id + "\t" + login + "\t" + password + "\t" + email + "\t" + phone + "]";
    }
}
