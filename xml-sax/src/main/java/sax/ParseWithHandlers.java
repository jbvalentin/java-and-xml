package sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import sax.generic.GenericContentHandler;
import sax.generic.GenericDTDHandler;

/**
 * Exemple d'implémentation : <a href="http://docstore.mik.ua/orelly/xml/xmlnut/ch19_03.htm">XML in a nutshell 19.3. Filters</a> ou
 * <a href="http://docstore.mik.ua/orelly/xml/jxml/ch04_03.htm">Java and XML 4.3. Filters and Writers</a>
 * 
 * @author jbvalent
 *
 */
public class ParseWithHandlers {

	public static void main(String[] args) {
		
		try {
			XMLReader r = XMLReaderFactory.createXMLReader();
			
			r.setContentHandler(new GenericContentHandler());
			r.setDTDHandler(new GenericDTDHandler());
			
			r.parse(new InputSource(ParseWithHandlers.class.getClassLoader().getResourceAsStream("test1/samplexml.xml")));
			
			
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (SAXException e) {
			e.printStackTrace(System.err);
		}
		
	}

}
