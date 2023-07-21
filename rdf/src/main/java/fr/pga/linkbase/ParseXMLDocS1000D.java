package fr.pga.linkbase;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.apache.jena.ext.com.google.common.collect.ImmutableCollection;
import org.apache.xml.resolver.tools.CatalogResolver;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;



public class ParseXMLDocS1000D implements ContentHandler, ErrorHandler {

	private Path doc;

	private static CatalogResolver resolver = new CatalogResolver();
	
	private java.util.Deque<String> tagNest = new ArrayDeque<String>();
	
	public enum TagContent {
		DCTITLE("dc:title"), DCIDENTIFIER("dc:identifier"), DCDATE("dc:date"), IDSTATUS_DMC("dmc", "dmc/dmaddres/idstatus/dmodule");
		
		String elemKey;
		String elemPath;
		
		private TagContent(String keypath) {
			this.elemPath = keypath;
			this.elemKey = keypath;
		}
		private TagContent(String key, String path) {
			this.elemKey = key;
			this.elemPath = path;
		}
		
		public String getKey() {
			return elemKey;
		}
		
		public String getPath() {
			return elemPath;
		}
	}
	
	
	private Map<String, String> v = new HashMap<String, String>();
	private String activeTagKey = null;
	private Set<String> refs = new java.util.TreeSet<>();
	
	private String contentType = null;
	
	public String getContentType() {
		return contentType;
	}

	public Set<String> getRefs() {
		return refs;
	}
	
	public String getValue(TagContent t) {
		return v.get(t.getKey());
	}

	public ParseXMLDocS1000D(Path doc) {
		this.doc = doc;
	}

	public void startParseDocument() {
		try {
			// System.out.println(resolver.resolve("http://www.s1000d.org/S1000D_2-3-1/xml_schema_flat/techrep.xsd", ""));
			SAXParserFactory sf = SAXParserFactory.newInstance();
			sf.setValidating(true);
			sf.setFeature("http://apache.org/xml/features/validation/dynamic", true);
			
			XMLReader r = sf.newSAXParser().getXMLReader();
			r.setEntityResolver(resolver);
			r.setContentHandler(this);
			r.setErrorHandler(this);
			r.setFeature("http://apache.org/xml/features/validation/dynamic", true);
			
			r.parse(doc.toFile().toString());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
//		} catch (TransformerException e) {
//			e.printStackTrace();
		}
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {

	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (tagNest.isEmpty()) {
			contentType = qName;
		}
		tagNest.push(qName);
		Optional<String> tmpPath = tagNest.stream().reduce((r, t) -> r + "/" + t); //map(t -> "/" + t).re;
		if (tmpPath.isPresent()) {
			//System.out.println(" > " + tmpPath.get());
		
			if (Stream.of(TagContent.values()).anyMatch(tc -> tmpPath.get().startsWith(tc.getPath()))) {
			//if (TagContent.DCTITLE.toString().equals(qName) || TagContent.DCIDENTIFIER.toString().equals(qName)) {
				v.put(qName, "");
				activeTagKey = qName;
			} else if ("refdm".equals(qName)) {
//				System.out.println("  . added " +  atts.getValue("xlink:href"));
				refs.add(atts.getValue("xlink:href"));
			} else {
				//System.out.println("  >> " +  qName);
			}
		} else {
			System.out.println(" pas de path");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		Optional<String> tmpPath = tagNest.stream().reduce((r, t) -> r + "/" + t); //map(t -> "/" + t).re;
		if (tmpPath.isPresent()) {
			if (Stream.of(TagContent.values()).anyMatch(tc -> tmpPath.get().startsWith(tc.getPath()))) {
				activeTagKey = null;
//				System.out.println(qName + " -> " + v.get(qName));
			}
		} else {
			
		}
		tagNest.pop();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (activeTagKey != null) {
			v.put(activeTagKey, v.get(activeTagKey).concat(new String(ch, start, length))); 
		}
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	// Error handler
	@Override
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		//System.out.println("!!! " + exception.getMessage());
		
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		//System.out.println("!!! " + exception.getMessage());
		
	}

}
