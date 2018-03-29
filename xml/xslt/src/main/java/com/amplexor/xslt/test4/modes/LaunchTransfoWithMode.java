package com.amplexor.xslt.test4.modes;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.amplexor.xslt.test1.LaunchSimpleTransformation;
import com.amplexor.xslt.util.TransformerFactories;

public class LaunchTransfoWithMode {

	public static void main(String[] args) {
		TransformerFactory tf = TransformerFactory.newInstance(TransformerFactories.SAXON_TRANSFORMER_FACTORY.toString(), LaunchSimpleTransformation.class.getClassLoader());
		
		try {
			Transformer t = tf.newTransformer(new StreamSource(LaunchSimpleTransformation.class.getClassLoader().getResourceAsStream("test4/transfo.xsl")));
			
			// TODO : trouver un moyen d'activer le mode "index" défini dans la feuille de style
			t.transform(new StreamSource(ClassLoader.getSystemResourceAsStream("test4/in.xml")), new StreamResult(System.out));
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
