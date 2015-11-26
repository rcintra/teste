package br.ccb.com.dao;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ccb.com.bean.Movie;
import br.ccb.com.bean.MovieBean;

@RunWith(Arquillian.class)
public class MovieDAOTest {

	@Inject
	private MovieBean movieBean;
	 
	@Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
            .addAsResource("META-INF/test-persistence.xml")
            .addAsResource("META-INF/create.sql")
            .addAsResource("META-INF/drop.sql")
            .addAsResource("META-INF/load.sql");
        System.out.println(war.toString(true));
        return war;
    }
	
	/*@Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Outlet.class)
                .addClass(OutletService.class)
                .addClass(EntityManagerProducer.class)
                .addAsManifestResource("test-persistence.xml",
                    ArchivePaths.create("persistence.xml"))
                .addAsManifestResource("META-INF/beans.xml",
                    ArchivePaths.create("beans.xml"))
                .addAsResource("ValidationMessages.properties");
    }*/
	
	@Test
    public void testCriteria() {
        List<Movie> movies = movieBean.listMovies(); // <1> Get a list of all the movies in the database.
      /*  assertEquals(4, movies.size()); // <2> 4 movies loaded on the db, so the size shoud be 4.
        assertTrue(movies.contains(new Movie(1)));
        assertTrue(movies.contains(new Movie(2)));
        assertTrue(movies.contains(new Movie(3)));
        assertTrue(movies.contains(new Movie(4)));*/
    }
}
