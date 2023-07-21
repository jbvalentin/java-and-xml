package sax.filter1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class SingleUpperFilter extends XMLFilterImpl {
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = String.valueOf(ch, start, length).toUpperCase();
		s.getChars(0, s.length(), ch, start);
		//System.out.println("miaou");
		super.characters(ch, start, length);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// On supprime les "cover"
		if (!"cover".equals(localName)) {
			super.startElement(uri, localName, qName, atts);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (!"cover".equals(localName)) {
			super.endElement(uri, localName, qName);
		}
	}
	
	
}
