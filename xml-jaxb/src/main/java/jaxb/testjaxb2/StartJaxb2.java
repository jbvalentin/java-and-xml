package jaxb.testjaxb2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;

import jaxb.testjaxb2.xml.ListPerson;

public class StartJaxb2 {

	public static void main(String[] args) {
		System.out.println("Test avec des listes d'éléments");
		try {
			Unmarshaller m = null;
			JAXBContext jc = JAXBContext.newInstance(ListPerson.class);
			m = jc.createUnmarshaller();
			
			// test simple : remplissage des champs d'un Bean Java
			Object unmarshalledObj = m.unmarshal(new InputSource(ClassLoader.getSystemResourceAsStream("testjaxb2/testjaxb2.xml")));
			System.out.println(unmarshalledObj.toString());

		} catch (JAXBException e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}

	}

}
