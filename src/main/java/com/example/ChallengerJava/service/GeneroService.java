package com.example.ChallengerJava.service;


import com.example.ChallengerJava.dtos.GeneroDto;
import com.example.ChallengerJava.entity.GeneroEntity;
import com.example.ChallengerJava.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    ModelMapper mapper = new ModelMapper();
    private GeneroRepository generoRepository;
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<GeneroDto> obtenerGenero(){
        List<GeneroEntity> generoEntityList= generoRepository.findAll();
        List<GeneroDto> generoDtoList = new ArrayList<>(
                generoEntityList.stream().map(
                        generoEntity -> mapper.map(generoEntity,GeneroDto.class)
                )
                        .collect(Collectors.toList())
        );
        return generoDtoList;
    }
    public GeneroDto guardarGenero(GeneroDto generoDto){
        GeneroEntity generoEntity = mapper.map(generoDto, GeneroEntity.class);
         generoRepository.save(generoEntity);
        return generoDto;
    }

    public boolean eliminarGenero (Long id){
        try{
            generoRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


}
