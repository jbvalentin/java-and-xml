package jaxb.testjaxb1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;

import jaxb.testjaxb1.xml.Person;


public class StartJaxb1 {

	
	public static void main(String[] args) {
		try {
			Unmarshaller m = null;
			JAXBContext jc = JAXBContext.newInstance(Person.class);
			m = jc.createUnmarshaller();
			
			// test simple : remplissage des champs d'un Bean Java
			Object unmarshalledObj = m.unmarshal(new InputSource(ClassLoader.getSystemResourceAsStream("testjaxb1/person.xml")));
			System.out.println(unmarshalledObj.toString());
			
			
		} catch (JAXBException e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
	}
}
