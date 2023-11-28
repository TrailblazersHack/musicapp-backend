package ru.trailblazers.musicappbackend.config.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.trailblazers.musicappbackend.entity.User;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static ru.trailblazers.musicappbackend.entity.enums.Status.BANNED;
import static ru.trailblazers.musicappbackend.entity.enums.Status.CONFIRMED;

@AllArgsConstructor
public class BaseUserDetails implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !Objects.equals(BANNED, user.getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(CONFIRMED, user.getStatus());
    }
}