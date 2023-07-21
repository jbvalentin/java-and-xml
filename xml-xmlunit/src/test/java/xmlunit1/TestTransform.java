package xmlunit1;

import java.io.IOException;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.xpath.jaxp.XPathFactoryImpl;
import org.custommonkey.xmlunit.Transform;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Sample xmlunit1 test.
 * 
 * <p>Refer to http://www.xmlunit.org/</p>
 * 
 * @author jbvalent
 *
 */
public class TestTransform extends XMLTestCase {

	@Override
	public void setUp() throws Exception {
		XMLUnit.setSAXParserFactory("org.apache.xerces.jaxp.SAXParserFactoryImpl");
		// net.sf.saxon.TransformerFactoryImpl
		// org.apache.xalan.processor.TransformerFactoryImpl
		// ProfessionalTransformerFactory
		// EnterpriseTransformerFactory

		XMLUnit.setTransformerFactory("net.sf.saxon.TransformerFactoryImpl");
		XMLUnit.setNormalize(true);
	};

	/**
	 * A faire à cause des white spaces...
	 *
	 * @param doc
	 */
	private static void removeSpaceOnlyTextNodes(Document doc) {
		final XPath xpath = XPathFactoryImpl.newInstance().newXPath();
		try {
			// Récupération
			final NodeList nodes = (NodeList) xpath.evaluate("//text()", doc.getDocumentElement(),
					XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				final Node n = nodes.item(i);

				if (n.getNodeType() == Node.TEXT_NODE) {
					final Text tn = (Text) n;
					if (tn.getNodeValue().matches("\\s+")) {
						tn.getParentNode().removeChild(tn);
					}
				}

			}
		} catch (final XPathExpressionException xpe) {

		}

	}

	@Test()
	public void testTransfXSL() {

		final Transform t = new Transform(new InputSource("C:\\documents\\documents\\tmp\\src.xml"),
				new InputSource("C:\\documents\\documents\\tmp\\PDF_TDM.xsl"));

		try {
			final Document docControl = XMLUnit
					.buildControlDocument(new InputSource("C:\\documents\\documents\\tmp\\src_20151130184921759.xml"));

			final Document test = t.getResultDocument();
			// assertXMLEqual(docControl, test);
			removeSpaceOnlyTextNodes(docControl);
			removeSpaceOnlyTextNodes(test);

			assertXpathsEqual("/macrodm/MPM/LG[1]", docControl, "/macrodm/MPM/LG[1]", test);

			// XMLUnit.assertXpathsEquals();

		} catch (final TransformerException | SAXException | IOException | XpathException te) {
			System.out.println("Crotte de bouc");
			fail("Erreur de transformation");
		}
	}
}
