package sax.filter2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class FilterImplSecondLevel extends XMLFilterImpl {

	private String noticeableParent = null;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (noticeableParent != null) {
			super.startElement(uri, noticeableParent + localName, noticeableParent + qName, atts);
		} else {
			super.startElement(uri, localName, qName, atts);
		}
		
		if ("identification".equals(localName)) {
			noticeableParent = localName + "|";
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if ("identification".equals(localName)) {
			//raz de l'indicateur de parent
			noticeableParent = null;
		}
		
		if (noticeableParent != null) {
			super.endElement(uri, noticeableParent + localName, noticeableParent + qName);
		} else {
			super.endElement(uri, localName, qName);
		}
	}

}
