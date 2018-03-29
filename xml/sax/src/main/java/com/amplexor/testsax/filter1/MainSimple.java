package com.amplexor.testsax.filter1;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.amplexor.testsax.generic.GenericContentHandler;

/**
 * Exemple d'implémentation : <a href="http://docstore.mik.ua/orelly/xml/xmlnut/ch19_03.htm">XML in a nutshell 19.3. Filters</a> ou
 * <a href="http://docstore.mik.ua/orelly/xml/jxml/ch04_03.htm">Java and XML 4.3. Filters and Writers</a>
 * 
 * @author jbvalent
 *
 */
public class MainSimple {

	public static void main(String[] args) {
		//String xmlFile = "C:\\temp\\Renodoc_Defaut\\A400M\\remarquesNP_DR\\fradRepository.rem";
		//String xmlFile = "C:\\Work\\Projets\\5700331-Renodoc\\700-SVN\\RenodocFA\\pom.xml";
		
		//File f = new File(xmlFile);
		SingleUpperFilter fi = new SingleUpperFilter();
		
		try {
			XMLReader r = XMLReaderFactory.createXMLReader();
			fi.setParent(r);
			
			fi.setContentHandler(new GenericContentHandler());
			
			//System.out.println(r.getClass().getName());
			fi.parse(new InputSource(MainSimple.class.getClassLoader().getResourceAsStream("test1/samplexml.xml")));
			//fi.parse(xmlFile);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (SAXException e) {
			e.printStackTrace(System.err);
		}
		
	}

}
