package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticateResponse {

    private String jwt;

    public AuthenticateResponse() {
        super();
    }

    public AuthenticateResponse(@JsonProperty String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "AuthenticateResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
