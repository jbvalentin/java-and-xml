package com.amplexor.xmlunit1;

import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.Transform;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class TestSimpleTransform extends XMLTestCase {

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

	@Test()
	public void testTransfXSL() {

		final Transform t = new Transform(
				new InputSource(TestSimpleTransform.class.getClassLoader().getResourceAsStream("xslt/a.xml")),
				new InputSource(TestSimpleTransform.class.getClassLoader().getResourceAsStream("xslt/a.xsl")));

		try {
			final Document test = t.getResultDocument();
			assertXpathEvaluatesTo("Sample xhtml document", "/html/head/title", test);

		} catch (final TransformerException | XpathException te) {
			System.out.println("Crotte de bouc");
			Assert.fail("Erreur de transformation");
		}
	}

}
