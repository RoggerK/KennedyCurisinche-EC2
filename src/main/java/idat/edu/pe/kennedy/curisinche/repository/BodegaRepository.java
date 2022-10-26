package idat.edu.pe.kennedy.curisinche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.kennedy.curisinche.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {

}
