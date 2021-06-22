package com.gl.exercice.apiusers.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gl.exercice.apiusers.models.User;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UserResponse implements Serializable {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("modified")
    private Date modified;
    @JsonProperty("last_login")
    private Date lastLogin;
    @JsonProperty("token")
    private String token;
    @JsonProperty("isactive")
    private boolean active;

    public UserResponse(User user) {
        this.id = user.getId();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.lastLogin = user.getLastLogin();
        this.token = user.getToken();
        this.active = user.isActive();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
