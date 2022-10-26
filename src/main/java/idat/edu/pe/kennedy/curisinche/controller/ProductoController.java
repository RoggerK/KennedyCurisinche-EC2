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

import idat.edu.pe.kennedy.curisinche.model.Producto;
import idat.edu.pe.kennedy.curisinche.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listar() {
		return new ResponseEntity<List<Producto>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Producto> proId(@PathVariable Long id) {
		Producto producto = service.porId(id);
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Producto producto) {
		service.guardar(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
		service.actualizar(id, producto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
