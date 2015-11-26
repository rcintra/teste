package br.ccb.com.dao;

import java.util.logging.Logger;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ccb.com.bean.Movie;
import br.ccb.com.bean.MovieBean;

@RunWith(Arquillian.class)
public class MovieDAOClientTest {

	private static final Logger LOGGER = Logger.getLogger(MovieDAOClientTest.class.getName());
	 
    // Not managed, should be used for external calls (e.g. HTTP)
    @Deployment(testable = false)
    public static WebArchive createNotTestableDeployment() {
        final WebArchive war = ShrinkWrap.create(WebArchive.class, "example.war")
                .addClasses(Movie.class, MovieBean.class)
                .addAsResource("META-INF/test-persistence.xml");
                // Enable CDI
                //.addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
 
        LOGGER.info(war.toString(Formatters.VERBOSE));
 
        return war;
    }
    
    @Test
    public void testCriteria() {
    }
 
    /*@RunAsClient // Same as @Deployment(testable = false), should only be used in mixed mode
    @Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER)
    public void callServletToAddNewUserToDB(@ArquillianResource URL baseURL) throws IOException {
        // Servlet is listening at <context_path>/User
        final URL url = new URL(baseURL, "User");
        final User user = new User(1L, "Ike");
 
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
 
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
 
        assertEquals(builder.toString(), user.toString());
    }*/
}
