package ar.com.nacho.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.nacho.modelo.Persona;

@Repository
public interface Ipersona extends CrudRepository<Persona, Integer> {

}
