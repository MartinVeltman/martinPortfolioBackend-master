package com.martin.portfolio.services;

import com.martin.portfolio.DAO.UserDAO;
import com.martin.portfolio.models.User;
import com.martin.portfolio.payload.request.SignupRequest;
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


    public User getUserByToken(String jwt) {
        return this.userDAO.getUserByJwt(jwt);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }


}
