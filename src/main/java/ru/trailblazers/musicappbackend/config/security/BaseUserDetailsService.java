package ru.trailblazers.musicappbackend.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.trailblazers.musicappbackend.entity.User;
import ru.trailblazers.musicappbackend.exception.UserNotFoundException;
import ru.trailblazers.musicappbackend.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class BaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        return new BaseUserDetails(user);
    }
}