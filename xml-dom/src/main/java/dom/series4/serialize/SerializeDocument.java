package dom.series4.serialize;

import org.w3c.dom.DOMStringList;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class SerializeDocument {

	public static void serialize(Document doc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException {
		DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
		DOMImplementationLS domImplLs = (DOMImplementationLS) registry.getDOMImplementation("LS");

		LSSerializer serializer = domImplLs.createLSSerializer();

		// Setting options
		// available options : https://www.w3.org/TR/DOM-Level-3-Core/core.html#DOMConfiguration
		serializer.getDomConfig().setParameter("format-pretty-print", true);

		DOMStringList listParams = serializer.getDomConfig().getParameterNames();
		for (int i = 0; i < listParams.getLength(); i++) {
			System.out.println("Config param name: " + listParams.item(i));
		}

		LSOutput output = domImplLs.createLSOutput();
		output.setByteStream(System.out);

		// Alternatives :
		serializer.writeToString(doc);
		serializer.write(doc, output);
	}

}
