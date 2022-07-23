//ejecuta la logica de la api
//usa el repository para las conexiones

package com.example.ChallengerJava.service;

import com.example.ChallengerJava.entity.PersonajeEntity;
import com.example.ChallengerJava.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService   {

    public PersonajeService(PersonajeRepository personajeRepository) {

        this.personajeRepository = personajeRepository;
    }
    private PersonajeRepository personajeRepository;

    public List<PersonajeEntity> obtenerPersonajes (){

        return personajeRepository.findAll();
    }

    public PersonajeEntity guardarPersonaje(PersonajeEntity personajeE){
        return personajeRepository.save(personajeE);
    }

    public boolean eliminarGenero (Long id){
        try{
            personajeRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }

}}
