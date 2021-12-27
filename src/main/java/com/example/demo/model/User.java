package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Email
    @Pattern(regexp = "\\S+@\\S+\\.\\S+")
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    private String role;
    @OneToMany
    @JoinColumn
    private List<Recipe> recipes;
    public String getRole() {
        return role;
    }
}