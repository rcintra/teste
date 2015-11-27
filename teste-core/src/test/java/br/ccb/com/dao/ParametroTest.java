package br.ccb.com.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ccb.com.entity.ParametroDTO;
import br.ccb.com.repository.ParameterRepository;

@RunWith(Arquillian.class)
public class ParametroTest {
	
	@Deployment
	public static Archive<?> createDeployment() {
		
		Archive<?> jar = ShrinkWrap.create(JavaArchive.class, "teste-core.war")
				.addPackage(ParameterRepository.class.getPackage())
				.addPackage(ParametroDTO.class.getPackage())
                .addPackages(true, "br.ccb.com")
				.addAsManifestResource("META-INF/test-persistence.xml")
				.addAsManifestResource("jbossas-ds.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		
		return jar;
	}
	
	@Inject
	ParameterRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	UserTransaction utx;

	@Before
	public void preparePersistenceTest() throws Exception {
		clearDatabase();
		insertData();
		startTransaction();
	}

	@After
	public void commitTransaction() throws Exception {
		utx.commit();
	}

	private void clearDatabase() throws Exception {
		utx.begin();
		em.joinTransaction();
		em.createQuery("delete from ParametroDTO").executeUpdate();
		utx.commit();
	}

	private void insertData() throws Exception {
		utx.begin();
		em.joinTransaction();

		ParametroDTO mocnyFull = new ParametroDTO();
		mocnyFull.setNome("xxx");
		em.persist(mocnyFull);

		utx.commit();
	}

	private void startTransaction() throws Exception {
		utx.begin();
	}

	@Test
	public void test_dao() {
		repository.findAll();
	}

}
