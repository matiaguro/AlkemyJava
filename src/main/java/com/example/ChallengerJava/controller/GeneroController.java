package com.example.ChallengerJava.controller;


import com.example.ChallengerJava.entity.GeneroEntity;
import com.example.ChallengerJava.service.GeneroService;
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
    public List<GeneroEntity> obtenerGeneros (){
        return generoService.obtenerGenero();
    }
    @PostMapping()
    public GeneroEntity guardarGenero(@RequestBody GeneroEntity generoE){

        return generoService.guardarGenero(generoE);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
    boolean ok= this.generoService.eliminarGenero(id);
    if (ok){
        return "Se elimino el genero con el id "+ id;
    }else {
        return "No se pudo eliminar el genero con el id " +id;
    }

    }

}
