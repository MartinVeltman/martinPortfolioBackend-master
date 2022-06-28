package com.martin.portfolio.services;

import com.martin.portfolio.DAO.UserDAO;
import com.martin.portfolio.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    PasswordEncoder encoder;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }


}
