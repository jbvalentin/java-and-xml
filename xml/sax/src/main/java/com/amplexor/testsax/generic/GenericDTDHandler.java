package com.amplexor.testsax.generic;

import org.xml.sax.DTDHandler;
import org.xml.sax.SAXException;

public class GenericDTDHandler implements DTDHandler {

	@Override
	public void notationDecl(String name, String publicId, String systemId) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
			throws SAXException {
		System.out.println(name + " -> " + systemId + " (" + notationName + ")");
	}

}
