package br.ccb.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ccb.com.entity.ParametroValorDTO;

public class ParametroDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<ParametroValorDTO> findAll() {
		return em.createNamedQuery("findAll", ParametroValorDTO.class).getResultList();
	}
}
