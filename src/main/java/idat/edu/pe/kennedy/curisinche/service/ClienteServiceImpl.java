package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idat.edu.pe.kennedy.curisinche.model.Cliente;
import idat.edu.pe.kennedy.curisinche.repository.ClienteRepository;

public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Cliente porId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setIdCliente(0L);
		repository.save(cliente);
	}

	@Override
	public void actualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setIdCliente(id);
		repository.save(cliente);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
