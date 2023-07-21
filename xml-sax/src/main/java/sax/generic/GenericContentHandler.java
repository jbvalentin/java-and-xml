package sax.generic;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class GenericContentHandler implements ContentHandler {
	
	private int level = 0;

	private void printLevel() {
		for (int i = 0; i < level-1; i++) {
			System.out.print(" | ");
		}
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		printLevel();
		level++;
		System.out.println("E: [" + localName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		level++;
		printLevel();
		System.out.println("(t) " + String.valueOf(ch, start, length).replaceAll("\n", "¶"));
		level--;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("\\\\\\ end of document ///");
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		level--;
		//System.out.println("</" + localName + ">");
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		level++;
		printLevel();
		System.out.println("(?) [" + target + " -> " + data + "]");
		level--;
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println(" /// Beginning of document \\\\\\");		
	}


	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}


}
