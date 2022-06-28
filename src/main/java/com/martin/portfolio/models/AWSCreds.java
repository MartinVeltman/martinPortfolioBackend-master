package com.martin.portfolio.models;

import javax.persistence.*;

@Entity
public class AWSCreds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String accesskey;

    @Column
    private String secretkey;

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
