package com.example.ChallengerJava.controller;


import com.example.ChallengerJava.dtos.GeneroDto;
import com.example.ChallengerJava.entity.GeneroEntity;
import com.example.ChallengerJava.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    private GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GeneroDto> obtenerGeneros (){

        return generoService.obtenerGenero();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GeneroDto guardarGenero(@RequestBody GeneroDto generoDto){

        return generoService.guardarGenero(generoDto);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String eliminarPorId(@PathVariable("id")Long id){
    boolean ok= generoService.eliminarGenero(id);
    if (ok){
        return "Se elimino el genero con el id "+ id;
    }else {
        return "No se pudo eliminar el genero con el id " +id;
    }}




}
