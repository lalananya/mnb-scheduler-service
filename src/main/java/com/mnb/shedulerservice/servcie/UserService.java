package com.mnb.shedulerservice.servcie;


import com.mnb.shedulerservice.config.JwtConfig;
import com.mnb.shedulerservice.dto.request.LoginReq;
import com.mnb.shedulerservice.dto.request.SignUpReq;
import com.mnb.shedulerservice.dto.response.LoginResp;
import com.mnb.shedulerservice.model.User;
import com.mnb.shedulerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private ServiceHelperDB serviceHelperDB;

    @Autowired
    private ServiceHelperClient serviceHelperClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> foundUser = userRepository.findByUsername(username);
        User user = foundUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        // we have our user or the error
        // we get our roleList from the fetched user from db,

        // SimpleGrantedAuthority::new - this will just passs the string
        // lets say instead of List<String>, you have List<enum>, then you can use getName()
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (user.getUserRole() != null && !user.getUserRole().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPassword(),
                authorities
        );

        // in user class which spring understand, we have sent our username, password and role
        // these things are already provided by string thus we are using it,
        // it is not mandatory to use, but it sets the work easy , this common functionality
        // user authentication and authorization thus it is cool !
    }

    public LoginResp login(LoginReq loginReq) {
        Optional<User> foundUser = userRepository.findByUsername(loginReq.getUserName());
        User user = foundUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        // in real world, we throw error response -> to handle no username found case
        LoginResp loginResp;
        try {
            if(serviceHelperClient.validateClientCredentials(user, loginReq.getUserPassword())) {
                // password is same, generates a token
                String token = jwtConfig.generateToken(user.getUserName());
                // create loginResp and then return
                loginResp = serviceHelperClient.createClientLoginResponse(user, token, "Logged In Successfully", 200);
            }
            else {
                loginResp = serviceHelperClient.createClientLoginResponse(user, "", "Invalid Username / Password", 400);
            }
            return loginResp;
        } catch (Exception e) {
            loginResp = serviceHelperClient.createClientLoginResponse(user, "", "Something Went Wrong", 500);
            return loginResp;
        }
    }

    public LoginResp signUp(SignUpReq signUpReq) {
        LoginResp loginResp;
        User user = serviceHelperDB.parseSignUpResponse(signUpReq);
        try {
            user = userRepository.save(user);
            String token = jwtConfig.generateToken(user.getUserName());
            loginResp = serviceHelperClient.createClientLoginResponse(user, token, "Logged In Successfully", 200);
            return loginResp;
        }catch (Exception e) {
            loginResp = serviceHelperClient.createClientLoginResponse(user, "", "Something Went Wrong", 500);
            return loginResp;
        }
    }
}
