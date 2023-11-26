package ru.trailblazers.musicappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class User extends AbstractEntity {
    private String username;
    private Integer age;
    private String hashPassword;

    @OneToOne
    private Room room;

    @ManyToMany
    @JoinTable(name = "account_tracks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_favorite_tracks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set<Track> favoriteTracks = new HashSet<>();
}
