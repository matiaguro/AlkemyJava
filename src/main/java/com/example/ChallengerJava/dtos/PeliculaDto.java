package com.example.ChallengerJava.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDto {

    private String titulo;
    private String fechaCreacion;
    private int calificacion;
    private GeneroDto genero;

}
