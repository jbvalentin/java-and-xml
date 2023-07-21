package xslt.test2.chaining;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class LaunchChainedTransformations {
	
	
	
	public static void main(String[] args) {
		
		// Exemple récupéré à partir de http://blogger.ziesemer.com/2009/01/xml-and-xslt-tips-and-tricks-for-java.html
		
		SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", LaunchChainedTransformations.class.getClassLoader());
		
		System.out.println(stf.getClass().getName());
		try {
			
			TransformerHandler th1 = stf.newTransformerHandler(new StreamSource(LaunchChainedTransformations.class.getClassLoader().getResourceAsStream("test1/transfo.xsl")));
			TransformerHandler th2 = stf.newTransformerHandler(new StreamSource(LaunchChainedTransformations.class.getClassLoader().getResourceAsStream("test2/transfo-stage2.xsl")));
			
			th1.setResult(new SAXResult(th2));
			th2.setResult(new StreamResult(System.out));
			
			Transformer t = stf.newTransformer();
			t.transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test1/in.xml")), new SAXResult(th1));
			
			//Transformer tStage1 = tf.newTransformer();
			//Transformer tStage2 = tf.newTransformer();
			
			
			//tStage1.transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test1/in.xml")), new StreamResult(System.out));
			
			
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
