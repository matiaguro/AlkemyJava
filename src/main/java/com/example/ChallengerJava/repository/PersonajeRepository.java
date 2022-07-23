//hace las conecciones a la db
//usa el entity para saber q tipo de informacion va a usar

package com.example.ChallengerJava.repository;

import com.example.ChallengerJava.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {


}
