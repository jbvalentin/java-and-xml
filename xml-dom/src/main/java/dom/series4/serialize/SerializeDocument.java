package dom.series4.serialize;

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

		LSOutput output = domImplLs.createLSOutput();


	}

}
