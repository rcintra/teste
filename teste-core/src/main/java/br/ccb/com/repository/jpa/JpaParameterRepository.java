package br.ccb.com.repository.jpa;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ccb.com.entity.ParametroDTO;
import br.ccb.com.repository.ParameterRepository;

@RequestScoped
public class JpaParameterRepository implements ParameterRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<ParametroDTO> findAll() {
		return em.createNamedQuery("ParametroDTO.findAll", ParametroDTO.class).getResultList();
	}
	
	public void insert(ParametroDTO dto) {
		em.persist(dto);
	}
	
}
