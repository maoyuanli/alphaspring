package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.security.UserAccount;
import com.alphasmart.alphaspring.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private UserAccountService userAccountService;

    @Autowired
    public SecurityController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("api/setuser")
    public UserAccount newUserAccount(@RequestBody UserAccount userAccount) {
        return userAccountService.save(userAccount);
    }
}
