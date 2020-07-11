package ar.com.nacho.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nacho.interfaces.Ipersona;
import ar.com.nacho.interfazServicios.IpersonaServicios;
import ar.com.nacho.modelo.Persona;

@Service
public class PersonaServicios implements IpersonaServicios {

	@Autowired
	private Ipersona data;
	@Override
	public List<Persona> listar() {
	
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Persona persona) {
		int res=0;
		Persona p=data.save(persona);
		if(!persona.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {
		data.deleteById(id);
		
	}

	
}
