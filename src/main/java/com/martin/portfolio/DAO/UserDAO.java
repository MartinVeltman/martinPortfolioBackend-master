package com.martin.portfolio.DAO;

import com.martin.portfolio.models.User;
import com.martin.portfolio.payload.request.SignupRequest;
import com.martin.portfolio.repository.UserRepository;
import com.martin.portfolio.security.jwt.AuthTokenFilter;
import com.martin.portfolio.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthTokenFilter authTokenFilter;

    @Autowired
    UserRepository userRepository;

    public User getUserByJwt(String jwt) {
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public Boolean usernameAlreadyExists(SignupRequest signUpRequest){
        if(userRepository.existsByUsername(signUpRequest.getUsername())){
           return true;
        }
        return false;
    }

    public Boolean emailAlreadyExists(SignupRequest signUpRequest){
        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return true;
        }
        return false;
    }
}
