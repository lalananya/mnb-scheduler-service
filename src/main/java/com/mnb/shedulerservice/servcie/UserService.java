package com.mnb.shedulerservice.servcie;


import com.mnb.shedulerservice.config.JwtConfig;
import com.mnb.shedulerservice.dto.request.LoginReq;
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
    UserRepository userRepository;

    @Autowired
    JwtConfig jwtConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> foundUser = userRepository.findByUsername(username);
        User user = foundUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        // we have our user or the error
        // we get our roleList from the fetched user from db,

        // SimpleGrantedAuthority::new - this will just passs the string
        // lets say instead of List<String>, you have List<enum>, then you can use getName()
        List<SimpleGrantedAuthority> authorities = user.getUserRole() != null ? (
                user.getUserRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                ) : new ArrayList<>();

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
        LoginResp loginResp = new LoginResp();
        if(user.getUserPassword().equals(loginReq.getUserPassword())) {
            // password is same
            // generate a token
            // create loginResp and then return
            String token = jwtConfig.generateToken(user.getUserName());

            loginResp.setUserToken(token);
            loginResp.setUserName(user.getUserName());
            loginResp.setUserEmail(user.getUserEmail());
            loginResp.setStatus(200);
            loginResp.setMessage("Logged In Successfully");
            loginResp.setActiveRoles(user.getUserRole());
            return loginResp;
        }
        loginResp.setStatus(400);
        loginResp.setMessage("Bad Request");

        return loginResp;
    }
}
