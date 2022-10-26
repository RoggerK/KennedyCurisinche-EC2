package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import idat.edu.pe.kennedy.curisinche.model.Bodega;

public interface BodegaService {
	List<Bodega> listar();
	Bodega porId(Long id);
	void guardar(Bodega bodega);
	void actualizar(Long id, Bodega bodega);
	void eliminar(Long id);
}
