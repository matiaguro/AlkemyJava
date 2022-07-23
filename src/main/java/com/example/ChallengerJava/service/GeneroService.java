package com.example.ChallengerJava.service;


import com.example.ChallengerJava.entity.GeneroEntity;
import com.example.ChallengerJava.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<GeneroEntity> obtenerGenero(){
        return generoRepository.findAll();
    }
    public GeneroEntity guardarGenero(GeneroEntity generoE){

        return generoRepository.save(generoE);

    }


}
