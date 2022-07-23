//recibe la peticion web
//manda a llamar un service

package com.example.ChallengerJava.controller;

import com.example.ChallengerJava.entity.PersonajeEntity;
import com.example.ChallengerJava.service.PersonajeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    //autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
    PersonajeService personajeService;

    @GetMapping
    public List<PersonajeEntity> obtenerPersonajes(){
        return personajeService.obtenerPersonajes();
    }

    @PostMapping
    public PersonajeEntity guardarPersonaje(@RequestBody PersonajeEntity personajeE){
        return this.personajeService.guardarPersonaje(personajeE);
    }



}
