package com.amplexor.xmlunit1;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;

public class CheckUnitTest extends XMLTestCase {

	@Override
	public void setUp() throws Exception {
		XMLUnit.setControlParser("org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
		// this next line is strictly not required - if no test parser is
		// explicitly specified then the same factory class will be used for
		// both test and control
		XMLUnit.setTestParser("org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

		XMLUnit.setSAXParserFactory("org.apache.xerces.jaxp.SAXParserFactoryImpl");

		// A utiliser si on fait des transformation XSLT
		// XMLUnit.setTransformerFactory("org.apache.xalan.processor.TransformerFactoryImpl");
	}

	@Test
	public void testXpathValues() throws Exception {
		/*
		 * final String firstListItem =
		 * "/html/body/div[@id='myList']/h1/ol/li[1]"; final String
		 * secondListItem = "/html/body/div[@id='myList']/h1/ol/li[2]"; final
		 * String myHtmlPage = "...."; assertXpathValuesNotEqual(firstListItem,
		 * secondListItem, myHtmlPage);
		 */

		assertXMLEqual("<a b=\"2\" c=\"p\">youhou</a>", "<a c=\"p\" b=\"2\" >youhou</a>");
		// assertXMLEqual("<a></a>", "<a att=\"toto\"></a>");
	}
	
	@Test
	public void testXSLTransform() {
		
	}
	
}
