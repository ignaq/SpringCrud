package ar.com.nacho.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.nacho.interfazServicios.IpersonaServicios;
import ar.com.nacho.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaServicios servicios;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas = servicios.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "formulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Validated Persona persona, Model model ) {
		servicios.guardar(persona);
		return "redirect:/listar";
		
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=servicios.listarId(id);
		model.addAttribute("persona", persona);
		return "formulario";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		servicios.borrar(id);
		return "redirect:/listar";
	}
	
}
