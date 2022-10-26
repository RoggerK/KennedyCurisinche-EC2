package idat.edu.pe.kennedy.curisinche.service;

import java.util.List;

import idat.edu.pe.kennedy.curisinche.model.Producto;

public interface ProductoService {
	List<Producto> listar();
	Producto porId(Long id);
	void guardar(Producto producto);
	void actualizar(Long id, Producto producto);
	void eliminar(Long id);
}
