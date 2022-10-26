package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idat.edu.pe.kennedy.curisinche.model.Bodega;
import idat.edu.pe.kennedy.curisinche.repository.BodegaRepository;

public class BodegaServiceImpl implements BodegaService {
	@Autowired
	private BodegaRepository repository;
	
	@Override
	public List<Bodega> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Bodega porId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Bodega bodega) {
		// TODO Auto-generated method stub
		bodega.setIdBodega(0L);
		repository.save(bodega);
	}

	@Override
	public void actualizar(Long id, Bodega bodega) {
		// TODO Auto-generated method stub
		bodega.setIdBodega(id);
		repository.save(bodega);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
