package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.repositories.UserAccountRepository;
import com.alphasmart.alphaspring.security.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    public UserAccount save(UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }
}
