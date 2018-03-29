package parse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.amplexor.series2.parse.ParseDocument;

public class TestParseDocument {

	private ParseDocument parser;

	@Before
	public void setUpParseDocument() {
		this.parser = new ParseDocument();
	}

	@Test
	public void testGetDomFromParser() throws IOException, SAXException, ParserConfigurationException {

		final Document doc = this.parser.parseDocument("/documents/document1.xml");
		assertNotNull(doc);
		assertEquals("document", doc.getDocumentElement().getLocalName());

	}

}
