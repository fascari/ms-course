package com.fascari.hroauth.services;

import com.fascari.hroauth.dtos.UserDTO;
import com.fascari.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public UserDTO findByEmail(String email) {
        UserDTO user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: " + username);
        return user;
    }
}