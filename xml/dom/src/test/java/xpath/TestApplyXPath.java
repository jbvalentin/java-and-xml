package xpath;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.amplexor.series2.parse.ParseDocument;
import com.amplexor.series3.xpath.XPathQuery;

public class TestApplyXPath {

	private Document doc;

	@Before
	public void loadDocument() throws IOException, SAXException, ParserConfigurationException {
		final ParseDocument p = new ParseDocument();
		this.doc = p.parseDocument("/documents/document1.xml");
	}

	@Test
	public void testGetXPathSimple() throws XPathExpressionException {
		final XPathQuery xpq = new XPathQuery();

		final String res = xpq.performSimpleXPathQueryOnDom("/document/title", this.doc);
		assertEquals("TITRE", res);
	}

	@Test
	public void testGetXPathSimpleOnAttribute() throws XPathExpressionException {
		final XPathQuery xpq = new XPathQuery();

		final String res = xpq.performSimpleXPathQueryOnDom("//section/@id", this.doc);
		assertEquals("sect_1", res);
	}

	@Test
	public void testGetXPathSimpleWithPredicate() throws XPathExpressionException {
		final XPathQuery xpq = new XPathQuery();

		final String res = xpq.performSimpleXPathQueryOnDom("//section[@id='sect_1']/title", this.doc);
		assertEquals("Section 1", res);
	}
}
