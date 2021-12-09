package mx.com.sgah.capadatos;

import java.util.List;

import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.sgah.capadatos.domain.Movimiento;

@Repository	
public class MovimientoDaoImpl implements MovimientoDaoI {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addMovimiento(Movimiento movimiento) {
		em.persist(movimiento);
	}

	@Override
	public void updateMovimiento(Movimiento movimiento) {
		em.merge(movimiento);
	}

	@Override
	public void deleteMovimiento(Movimiento movimiento) {
		em.remove(movimiento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movimiento> findAllMovimiento() {
		String jpql = "select m from Movimiento m";
		Query query = em.createQuery(jpql);
		// forzar a ir directamente a la base de datos para refrescar datos
		query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
		
		return query.getResultList();
	}

	@Override
	public Movimiento findMovimientoById(Movimiento movimiento) {
		return em.find(Movimiento.class, movimiento.getIdMovimiento());
	}

}
