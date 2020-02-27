package com.alphasmart.alphaspring.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String userName;

    private String email;
    private String password;
    private boolean enabled=true;

    @JsonProperty("user")
    private void unpackRawUserAccount(Map<String, Object> user){
        this.userName = (String) user.get("user_name");
        this.password = (String) user.get("password");
        this.email = (String) user.get("email");
    }

    protected UserAccount() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
