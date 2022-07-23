package com.example.ChallengerJava.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table (name ="personaje")
public class PersonajeEntity {
    @Id //id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //genera automatico y auto incremetando
    @Column(unique = true,nullable = false) //unico y no nulo
    private Long id;
    private String nombre;
    private String edad;
    private String peso;
    private String historia;

}
