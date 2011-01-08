package com.soebes.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestBase {

    public final String XMLFILE = getTargetDir() + File.separator + "test.xml";

    @Test
    public void writeXMLOutputTest() throws JAXBException, IOException, URISyntaxException {
        JAXBContext context = JAXBContext.newInstance(Configuration.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Configuration config = new Configuration();
        Repository repo = new Repository();
        repo.setId("SupoSE");
        repo.setUri(new URI("file:///svn.test.com/project/trunk"));
        repo.setUsername("kama");
        repo.setPassword("password");
        config.addRepository(repo);
        config.getResults().put(repo.getId(), repo);

        repo = new Repository();
        repo.setId("Test");
        repo.setUri(new URI("http://svn.test.com/p/branches"));
        repo.setUsername("egon");
        repo.setPassword("egon");
        config.addRepository(repo);
        config.getResults().put(repo.getId(), repo);

        FileOutputStream fout = new FileOutputStream(XMLFILE);
        m.marshal(config, fout);
        fout.close();
    }

    @Test(dependsOnMethods = { "writeXMLOutputTest" })
    public void readXMLTest() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Configuration.class);
        Unmarshaller um = context.createUnmarshaller();
        Configuration configuration = (Configuration) um.unmarshal(new FileReader(XMLFILE));
        for (Repository repository : configuration.getRepositories()) {
            System.out.println("Username: " + repository.getUsername());
            System.out.println("Password: " + repository.getPassword());
            System.out.println("URL: " + repository.getUri());
        }
    }
}
