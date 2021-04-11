package com.example.my_app;

import java.lang.reflect.Array;

public class LoginResponse {
    private String status;
    private String pesan;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
