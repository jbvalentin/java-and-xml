package xslt.test3;

import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import xslt.util.TransformerFactories;

public class LaunchSimpleTransformationUnparsedEntities {
	 
	
	public static void main(String[] args) {
		
		SAXTransformerFactory stf = (SAXTransformerFactory) TransformerFactory.newInstance(
				TransformerFactories.SAXON_TRANSFORMER_FACTORY.toString(),
				LaunchSimpleTransformationUnparsedEntities.class.getClassLoader());
		
		try {
			TransformerHandler thTransf = stf
					.newTransformerHandler(new StreamSource(LaunchSimpleTransformationUnparsedEntities.class
							.getClassLoader().getResourceAsStream("test3/transfo.xsl")));
			
			thTransf.setResult(new StreamResult(System.out));
			
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(thTransf);
			reader.setDTDHandler(thTransf);
			reader.parse(new InputSource(LaunchSimpleTransformationUnparsedEntities.class.getClassLoader().getResourceAsStream("test3/in.xml")));
			
			
//			thTransf.getTransformer().transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test3/in.xml")),
//					new StreamResult(System.out));
			
			
//			Transformer t = stf.newTransformer();
//			t.transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test3/in.xml")),
//					new SAXResult(thTransf));

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
//		} catch (TransformerException e) {
//			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
