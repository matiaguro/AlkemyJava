package com.example.ChallengerJava.controller;


import com.example.ChallengerJava.dtos.PeliculaDto;
import com.example.ChallengerJava.entity.PeliculaEntity;
import com.example.ChallengerJava.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PeliculaDto> obtenerPelicula(){

        return peliculaService.obtenerPeliculas();

    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PeliculaDto guardarPelicula(@RequestBody PeliculaDto peliculaDto){

        return peliculaService.guardarPelicula(peliculaDto);

    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok= this.peliculaService.eliminarGenero(id);
        if (ok){
            return "Se elimino el pelicula con el id "+ id;
        }else {
            return "No se pudo eliminar el pelicula con el id " +id;
        }

    }



}
