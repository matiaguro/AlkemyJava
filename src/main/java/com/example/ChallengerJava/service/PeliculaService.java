package com.example.ChallengerJava.service;


import com.example.ChallengerJava.entity.PeliculaEntity;
import com.example.ChallengerJava.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private PeliculaRepository peliculaRepository;
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<PeliculaEntity> obtenerPersonajes(){
    return peliculaRepository.findAll();

    }

    public PeliculaEntity guardarPelicula( PeliculaEntity peliculaE){
        return peliculaRepository.save(peliculaE);
    }

    public boolean eliminarGenero (Long id){
        try{
            peliculaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
}}
