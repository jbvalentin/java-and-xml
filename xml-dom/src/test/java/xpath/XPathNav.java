package xpath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import dom.series2.parse.ParseDocument;

public class XPathNav {

    @Test
    public void testXPath() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		Document doc = dbf.newDocumentBuilder().parse(ParseDocument.class.getResourceAsStream("/documents/document1.xml"));


        final XPathFactory factory = XPathFactory.newInstance();
		final XPath xPath = factory.newXPath();

		final XPathExpression xPe = xPath.compile("/document//p[@id=\"p1\"]");
		Element para1 = (Element)xPe.evaluate(doc, XPathConstants.NODE);
        assertNotNull(para1);
        assertEquals("p1", para1.getAttribute("id"));

        final XPathExpression getParentXPath = xPath.compile("../");
        Element parentSection = (Element)getParentXPath.evaluate(para1, XPathConstants.NODE);


        assertNotNull(parentSection);
        assertEquals("sect_1", parentSection.getAttribute("id"));



    }
    
}
