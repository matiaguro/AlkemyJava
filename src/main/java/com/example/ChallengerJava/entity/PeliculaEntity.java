package com.example.ChallengerJava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name="pelicula")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true,nullable = false)
    private Long id;
    private String titulo;
    private String fechaCreacion;
    private int calificacion;

}
