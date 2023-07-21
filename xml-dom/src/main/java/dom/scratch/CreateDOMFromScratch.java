package dom.scratch;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class CreateDOMFromScratch {

	public Document createADOMFromScratch() throws ParserConfigurationException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		System.out.println(dbf.getClass().getName());// org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
		// Create a new document instance
		final Document d = dbf.newDocumentBuilder().newDocument();

		// Create an element named "root"
		final Element e = d.createElement("root");
		// Add it to the tree
		final Node root = d.appendChild(e);

		// TODO Also create some attributes
		final Attr a = d.createAttribute("id");
		a.setValue("id_1234");
		root.appendChild(a);

		// Create some text
		final Text t = d.createTextNode("Lorem ipsum dolor sit amet.");
		// Add as a child of the element previously created.
		root.appendChild(t);

		return d;

	}

	public static void main(final String[] args) throws ParserConfigurationException {
		new CreateDOMFromScratch().createADOMFromScratch();

	}

}
