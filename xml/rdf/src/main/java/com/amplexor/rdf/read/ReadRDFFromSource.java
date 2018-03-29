package com.amplexor.rdf.read;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

public class ReadRDFFromSource {

	public static void main(final String[] args) {
		final Model model = ModelFactory.createDefaultModel();

		try {
			model.read(ReadRDFFromSource.class.getResourceAsStream("/foaf/foaf.xml"), "RDF/XML");
			model.write(System.out);
			final Resource r = ResourceFactory.createResource("http://dig.csail.mit.edu/data#DIG");
			final Property p = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/", "member");
			// OK
			System.out.println("Contains : " + model.contains(r, p));
		} catch (final Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
