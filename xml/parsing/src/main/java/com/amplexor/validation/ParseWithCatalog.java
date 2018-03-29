package com.amplexor.validation;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.resolver.tools.CatalogResolver;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ParseWithCatalog implements ErrorHandler {

    public static void main(String[] args) {
		final CatalogResolver resolver = new org.apache.xml.resolver.tools.CatalogResolver();
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
	
		    dbf.setValidating(true);
		    dbf.setFeature("http://apache.org/xml/features/validation/dynamic", true);
		    final DocumentBuilder parser = dbf.newDocumentBuilder();
		    parser.setEntityResolver(resolver);
		    System.out.println(resolver.getResolvedEntity("ISO 8879-1986//ENTITIES General Technical//EN", "test.ent"));
		    parser.setErrorHandler(new ParseWithCatalog());
		    final Document doc = parser.parse(ParseWithCatalog.class.getClassLoader().getResourceAsStream("parsing-catalog/doc1.xml"));
		} catch (IOException | ParserConfigurationException | SAXException e) {
		    System.out.println("Error: " + e.getMessage());
		    e.printStackTrace(System.out);
		}

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
	System.out.println("[Error] " + exception.getMessage());

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
	System.out.println("[Fatal Error] " + exception.getMessage());

    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
	System.out.println("[Warn] " + exception.getMessage());

    }

}
