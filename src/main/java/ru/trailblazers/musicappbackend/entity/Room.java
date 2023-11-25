package ru.trailblazers.musicappbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room extends AbstractEntity {
    private String title;
    private Integer limitUsers;
    private Boolean privacy;
    @OneToMany
    private List<User> users;
}
