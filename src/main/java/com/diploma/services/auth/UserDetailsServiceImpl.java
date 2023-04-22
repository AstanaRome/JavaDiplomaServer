package com.diploma.services.auth;


import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

public class UserDetailsServiceImpl implements UserDetailsService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}
