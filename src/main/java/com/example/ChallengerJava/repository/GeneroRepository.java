package com.example.ChallengerJava.repository;


import com.example.ChallengerJava.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long> {

}
