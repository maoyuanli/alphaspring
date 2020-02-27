package com.alphasmart.alphaspring.repositories;

import com.alphasmart.alphaspring.security.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
