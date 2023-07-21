package sax.filter2;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class FilterImplFirstLevel extends XMLFilterImpl {
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = String.valueOf(ch, start, length).toUpperCase();
		s.getChars(0, s.length(), ch, start);
		System.err.print("{Conversion majuscules}");
		super.characters(ch, start, length);
	}
}
