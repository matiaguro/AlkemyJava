package com.example.ChallengerJava.controller;


import com.example.ChallengerJava.entity.PeliculaEntity;
import com.example.ChallengerJava.service.PeliculaService;
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
    public List<PeliculaEntity> obtenerPersonajes(){

        return peliculaService.obtenerPersonajes();

    }
    @PostMapping()
    public PeliculaEntity guardarPelicula(@RequestBody PeliculaEntity peliculaE){

        return peliculaService.guardarPelicula(peliculaE);

    }
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok= this.peliculaService.eliminarGenero(id);
        if (ok){
            return "Se elimino el pelicula con el id "+ id;
        }else {
            return "No se pudo eliminar el pelicula con el id " +id;
        }

    }



}
