package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;
    private String password;
    private boolean active;

    @ManyToMany(fetch = EAGER)
    private Collection<AppRole> appRoles = new ArrayList<>();


}
