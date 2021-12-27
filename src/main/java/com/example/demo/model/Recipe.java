package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Recipe {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    User user;

    @NotBlank
    String name, description, category;

    LocalDateTime date;

    @NotEmpty
    @Column(length = 1000)
    String[] ingredients, directions;
}