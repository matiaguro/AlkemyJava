package com.example.ChallengerJava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
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
    @NotNull
    private String titulo;
    private String fechaCreacion;
    private int calificacion;

    @ManyToOne//(fetch = FetchType.LAZY, optional = false)// carga peresoza (carga cuando indicamos)
    //@JoinColumn(name = "genero_entity_id", nullable=false)//indica que es la dueña
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//ignora serializar
    private GeneroEntity genero;//tiene que ser igual en el DTO


}
