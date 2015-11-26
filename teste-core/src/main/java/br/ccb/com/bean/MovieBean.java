package br.ccb.com.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class MovieBean {

	@PersistenceContext
    private EntityManager em;
	
	public List<Movie> listMovies() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Movie> listCriteria = builder.createQuery(Movie.class);
        Root<Movie> listRoot = listCriteria.from(Movie.class);
        listCriteria.select(listRoot);
        TypedQuery<Movie> query = em.createQuery(listCriteria);
        return query.getResultList();
    }

}
