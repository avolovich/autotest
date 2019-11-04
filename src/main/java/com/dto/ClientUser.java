package com.dto;

public class ClientUser {
    private String username;
    private String password;
    private String fullName;
    private String tenantId;

    public String getUsername() {
        return username;
    }

    public ClientUser setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public ClientUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public ClientUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public ClientUser setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
