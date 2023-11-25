package ru.trailblazers.musicappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trailblazers.musicappbackend.entity.Track;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<Track, UUID> {
}
