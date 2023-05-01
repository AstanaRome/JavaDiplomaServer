package com.diploma.services;

import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User, UserRepository> {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repository){super(repository);}


    @Override
    public User saveOrUpdate (User user){
        User userFromBd = userRepository.getUserByUsername(user.getUsername());

        if (userFromBd == null) {
            String password = user.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String testPasswordEncoded = passwordEncoder.encode(password);
            user.setPassword(testPasswordEncoded);
        } else{
            if(!userFromBd.getPassword().equals(user.getPassword())){
                String password = user.getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String testPasswordEncoded = passwordEncoder.encode(password);
                user.setPassword(testPasswordEncoded);
            }

        }

        return userRepository.save(user);
    }


}
