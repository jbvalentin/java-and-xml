package scratch;

import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.amplexor.scratch.CreateDOMFromScratch;

public class TestCreateDomFromScratch {

	private static final Logger LOGGER = Logger.getLogger(TestCreateDomFromScratch.class.getName());

	@Test
	public void testDocumentRoot() {
		try {
			final Document dtest = new CreateDOMFromScratch().createADOMFromScratch();
			// It's a document
			Assert.assertEquals(Node.DOCUMENT_NODE, dtest.getNodeType());
			// DocumentElement is an element
			Assert.assertEquals(Node.ELEMENT_NODE, dtest.getDocumentElement().getNodeType());
			// DocumentElement is <root>
			Assert.assertEquals("root", dtest.getDocumentElement().getTagName());
			Assert.assertEquals(1, dtest.getChildNodes().getLength());

		} catch (final ParserConfigurationException e) {
			LOGGER.warning(e.getMessage());
		}

	}

}
