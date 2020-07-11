package ar.com.nacho.interfazServicios;

import java.util.List;
import java.util.Optional;

import ar.com.nacho.modelo.Persona;

public interface IpersonaServicios {
	
	public List <Persona> listar();
	public Optional<Persona>listarId(int id);
	public int guardar (Persona persona);
	public void borrar (int id);
	

}
