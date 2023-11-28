package ru.trailblazers.musicappbackend.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Track extends AbstractEntity {
    private String title;
    private Long duration;
    private String url;
}
