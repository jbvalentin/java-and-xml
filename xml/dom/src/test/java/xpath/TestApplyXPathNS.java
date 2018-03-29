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
import com.amplexor.series3.xpath.XPathQueryNS;

/**
 * Applying XPath expressions with namespaces.
 *
 * @author jbvalent
 *
 */
public class TestApplyXPathNS {

	private Document doc;

	@Before
	public void loadDocument() throws IOException, SAXException, ParserConfigurationException {
		final ParseDocument p = new ParseDocument();
		this.doc = p.parseDocument("/documents/document2-with-default-xmlns.xml");
	}

	@Test
	public void testGetXPathSimple() throws XPathExpressionException {
		final XPathQueryNS xpq = new XPathQueryNS();

		final String res = xpq.performSimpleXPathQueryOnDom("/xhtml:html/xhtml:head/xhtml:title", this.doc);
		assertEquals("TITRE", res);
	}

	@Test
	public void testGetXPathSimpleOnAttribute() throws XPathExpressionException {
		final XPathQueryNS xpq = new XPathQueryNS();

		final String res = xpq.performSimpleXPathQueryOnDom("//xhtml:section/@id", this.doc);
		assertEquals("sect_1", res);
	}

	@Test
	public void testGetXPathSimpleWithPredicate() throws XPathExpressionException {
		final XPathQueryNS xpq = new XPathQueryNS();

		final String res = xpq.performSimpleXPathQueryOnDom("//xhtml:section[@id='sect_1']/xhtml:title", this.doc);
		assertEquals("Section 1", res);
	}
}
