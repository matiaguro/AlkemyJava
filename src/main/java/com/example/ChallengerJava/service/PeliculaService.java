package com.example.ChallengerJava.service;



import com.example.ChallengerJava.dtos.GeneroDto;
import com.example.ChallengerJava.dtos.PeliculaDto;

import com.example.ChallengerJava.entity.GeneroEntity;
import com.example.ChallengerJava.entity.PeliculaEntity;
import com.example.ChallengerJava.repository.GeneroRepository;
import com.example.ChallengerJava.repository.PeliculaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaService {
    ModelMapper mapper = new ModelMapper();
    private PeliculaRepository peliculaRepository;
    private GeneroRepository generoRepository;
    public PeliculaService(PeliculaRepository peliculaRepository,GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.generoRepository = generoRepository;
    }

    public List<PeliculaDto> obtenerPeliculas(){
        List<PeliculaEntity> peliculaEntityList= peliculaRepository.findAll();
        List<PeliculaDto> peliculaDtoList = new ArrayList<>(
                peliculaEntityList.stream().map(
                                peliculaEntity -> mapper.map(peliculaEntity,PeliculaDto.class)
                        )
                        .collect(Collectors.toList())
        );
        return peliculaDtoList;
    }

    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto){
        Optional<GeneroEntity> generoEntity= generoRepository.findByNombreEquals(peliculaDto.getGenero().getNombre());
        PeliculaEntity peliculaEntity = mapper.map(peliculaDto, PeliculaEntity.class);
        if(generoEntity.isEmpty()) {
           GeneroEntity generoEntityAGuardar = mapper.map(peliculaDto.getGenero(), GeneroEntity.class);
            generoRepository.save(generoEntityAGuardar);
            Optional<GeneroEntity> generoEntityConId= generoRepository.findByNombreEquals(peliculaDto.getGenero().getNombre());
            peliculaEntity.setGenero(generoEntityConId.get());
        }else{
            peliculaEntity.setGenero(generoEntity.get());
        }
        peliculaRepository.save(peliculaEntity);
        return peliculaDto;
    }

    public boolean eliminarGenero (Long id){
        try{
            peliculaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
}}
