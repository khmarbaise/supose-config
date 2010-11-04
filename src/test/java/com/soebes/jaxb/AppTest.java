package com.soebes.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

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
	public void writeXMLOutputTest() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Configuration.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Configuration config = new Configuration();
		config.setName("ThisIsTheName");
		FileOutputStream fout = new FileOutputStream(XMLFILE);
		m.marshal(config, fout);
		fout.close();
	}

	@Test(dependsOnMethods = { "writeXMLOutputTest" })
	public void readXMLTest() throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Configuration.class);
		Unmarshaller um = context.createUnmarshaller();
		Configuration configuration = (Configuration) um.unmarshal(new FileReader(XMLFILE));
		System.out.println("Configuration: " + configuration.getName());
	}
}
