package com.jesthercostinar.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos") // @Table annotation makes "tados" table map in this Jpa Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generate the primary key as AUTO INCREMENT
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private boolean isCompleted;
}