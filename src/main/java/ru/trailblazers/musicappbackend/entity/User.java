package ru.trailblazers.musicappbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(schema = "account")
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
}
