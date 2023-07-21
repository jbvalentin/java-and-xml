package xslt.test1;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import xslt.util.TransformerFactories;

public class LaunchSimpleTransformation {

	public static void main(String[] args) {
		TransformerFactory tf = TransformerFactory.newInstance(
				TransformerFactories.SAXON_TRANSFORMER_FACTORY.toString(),
				LaunchSimpleTransformation.class.getClassLoader());

		try {
			Transformer t = tf.newTransformer(new StreamSource(
					LaunchSimpleTransformation.class.getClassLoader().getResourceAsStream("test1/transfo.xsl")));

			t.transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test1/in.xml")),
					new StreamResult(System.out));

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
