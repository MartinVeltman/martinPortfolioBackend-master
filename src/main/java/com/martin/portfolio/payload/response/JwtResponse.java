package com.martin.portfolio.payload.response;

public class JwtResponse {
    private String token;

    public JwtResponse(String accesToken) {
        this.token = accesToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }


}
