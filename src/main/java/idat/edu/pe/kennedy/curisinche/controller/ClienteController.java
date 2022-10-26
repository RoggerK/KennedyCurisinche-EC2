package idat.edu.pe.kennedy.curisinche.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.kennedy.curisinche.model.Cliente;
import idat.edu.pe.kennedy.curisinche.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listar() {
		return new ResponseEntity<List<Cliente>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Cliente> proId(@PathVariable Long id) {
		Cliente cliente = service.porId(id);
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
		service.guardar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		service.actualizar(id, cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
