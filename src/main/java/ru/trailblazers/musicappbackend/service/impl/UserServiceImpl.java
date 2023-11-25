package ru.trailblazers.musicappbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;
import ru.trailblazers.musicappbackend.entity.User;
import ru.trailblazers.musicappbackend.entity.enums.Status;
import ru.trailblazers.musicappbackend.exception.UserNotFoundException;
import ru.trailblazers.musicappbackend.repository.UserRepository;
import ru.trailblazers.musicappbackend.service.UserService;
import ru.trailblazers.musicappbackend.util.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

//    @Override
//    @Transactional
//    public UserResponse addNewUser(UserRequest request) {
//        User user = mapper.toEntity(request);
//        user.setId(UUID.randomUUID());
//        user.setStatus(Status.CONFIRMED);
//        repository.save(user);
//        return mapper.toDto(user);
//    }

    @Override
    public UserResponse updateUserById(UUID userId, UserRequest request) {
        User user = getByIdOrThrow(userId);
        user.setUsername(request.getUsername());
        user.setAge(request.getAge());
        repository.save(user);
        return mapper.toDto(user);
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        User user = getByIdOrThrow(userId);
        return mapper.toDto(user);
    }

    @Override
    public void deleteUserById(UUID userId) {
        User user = getByIdOrThrow(userId);
        user.setStatus(Status.DELETED);
        repository.save(user);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = repository.findAll();
        return mapper.toDtoList(users);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) repository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    private User getByIdOrThrow(UUID userId) {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            User getUser = user.get();
            if (getUser.getStatus().equals(Status.DELETED)) {
                throw new UserNotFoundException(userId);
            }
            return getUser;
        } else {
            throw new UserNotFoundException(userId);
        }
    }
}
