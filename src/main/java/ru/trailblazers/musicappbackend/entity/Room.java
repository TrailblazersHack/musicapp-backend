package ru.trailblazers.musicappbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room extends AbstractEntity {
    private String title;

    @OneToOne
    private User host;

    @OneToMany
    private List<User> users;
}
