package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import idat.edu.pe.kennedy.curisinche.model.Cliente;

public interface ClienteService {
	List<Cliente> listar();
	Cliente porId(Long id);
	void guardar(Cliente cliente);
	void actualizar(Long id, Cliente cliente);
	void eliminar(Long id);
}
