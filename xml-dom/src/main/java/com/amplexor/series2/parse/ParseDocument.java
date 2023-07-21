package com.amplexor.series2.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParseDocument {

	public Document parseDocument(final String resource)
			throws IOException, SAXException, ParserConfigurationException {

		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		return dbf.newDocumentBuilder().parse(ParseDocument.class.getResourceAsStream(resource));

	}

}
