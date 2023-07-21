package xmlunit2;

import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xmlunit.transform.Transformation;

/**
 * XMLUnit version 2 tests.
 * 
 * @author jbvalent
 *
 */
public class TestControlTransformXmlUnit2 {

	@Test
	public void testTransfXSLXMLUnit2() {
		// Test avec la nouvelle version de XML Unit
		Transformation t = new Transformation(new StreamSource(
				TestControlTransformXmlUnit2.class.getClassLoader().getResourceAsStream("xslt/a.xml")));
		t.setFactory(net.sf.saxon.TransformerFactoryImpl.newInstance());
		t.setStylesheet(new StreamSource(
				TestControlTransformXmlUnit2.class.getClassLoader().getResourceAsStream("xslt/a.xsl")));

		Document docOut = t.transformToDocument();

		// System.out.println(t.transformToString());
		Assert.fail();

	}

}
