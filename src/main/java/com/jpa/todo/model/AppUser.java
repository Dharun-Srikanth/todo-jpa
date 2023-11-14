package com.jpa.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userID;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;
}
