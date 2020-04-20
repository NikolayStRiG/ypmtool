package org.sterzhen.ypmtool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.sterzhen.ypmtool.data.repositories.ToolUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ToolUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(ToolUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByLogin(username)
                .map(MyUserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
