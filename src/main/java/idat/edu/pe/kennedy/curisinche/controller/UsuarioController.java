package idat.edu.pe.kennedy.curisinche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.kennedy.curisinche.dto.UsuarioDTORequest;
import idat.edu.pe.kennedy.curisinche.dto.UsuarioDTOResponse;
import idat.edu.pe.kennedy.curisinche.security.TokenUtil;

@RestController
public class UsuarioController {
	@Autowired
	private TokenUtil util;

	@Autowired
	private UserDetailsService service;

	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request) {
		UserDetails user = service.loadUserByUsername(request.getUsuario());
		if (request.getContrasenia().equals(user.getPassword().toString())){
			return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
		} else {
			throw new UsernameNotFoundException("Usuario y/o Contraseña incorrecto ");
		}
		
	}

}
