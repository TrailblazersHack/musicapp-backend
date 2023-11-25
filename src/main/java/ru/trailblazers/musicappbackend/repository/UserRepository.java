package ru.trailblazers.musicappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trailblazers.musicappbackend.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UUID, User> {
}
