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

import idat.edu.pe.kennedy.curisinche.model.Bodega;
import idat.edu.pe.kennedy.curisinche.service.BodegaService;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {
	@Autowired
	private BodegaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Bodega>> listar() {
		return new ResponseEntity<List<Bodega>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Bodega> proId(@PathVariable Long id) {
		Bodega bodega = service.porId(id);
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bodega>(bodega, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Bodega bodega) {
		service.guardar(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Bodega bodega) {
		service.actualizar(id, bodega);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
