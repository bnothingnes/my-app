package com.example.my_app;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;

    public String getNama() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
