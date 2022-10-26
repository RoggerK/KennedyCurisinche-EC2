package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idat.edu.pe.kennedy.curisinche.model.Producto;
import idat.edu.pe.kennedy.curisinche.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Producto porId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		producto.setIdProducto(0L);
		repository.save(producto);
	}

	@Override
	public void actualizar(Long id, Producto producto) {
		// TODO Auto-generated method stub
		producto.setIdProducto(id);
		repository.save(producto);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
