package rdf.read;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.SKOS;


public class ReadRDFTriples {

	public static void main(String[] args) {
		
		final Model model = ModelFactory.createDefaultModel();
		
		
		Resource jlborges = model.createResource("http://mylibrary/author/jlborges");
		jlborges.addProperty(org.apache.jena.vocabulary.DCTerms.description, "Jorge Luis Borges");
		
		Resource avialatte = model.createResource("http://mylibrary/author/avialatte");
		avialatte.addProperty(org.apache.jena.vocabulary.DCTerms.description, "Alexandre Vialatte");
		
		
		
		model.createResource("http://mylibrary/lelivredesable")
				.addProperty(DC_11.title, "Le livre de sable")
				.addProperty(DC_11.creator, jlborges);

		model.createResource("http://mylibrary/lerapportdebrodie")
				.addProperty(DC_11.title, "Le rapport de Brodie")
				.addProperty(DC_11.creator, jlborges);

		model.createResource("http://mylibrary/lesfruitsducongo")
				.addProperty(DC_11.title, "Les fruits du Congo")
				.addProperty(DC_11.creator, avialatte);
		
		model.createResource("http://mylibrary/nouvellesorientales")
				.addProperty(DC_11.title, "Nouvelles orientales")
				.addProperty(DC_11.creator, model.createResource("http://mylibrary/author/myourcenar"));

		model.createResource("http://mylibrary/author/myourcenar").addProperty(org.apache.jena.vocabulary.DCTerms.description, "Marguerite Yourcenar");
		
		String queryString = "SELECT ?title "
				+ " WHERE { ?x  <http://purl.org/dc/terms/description> \"Marguerite Yourcenar\" ."
				+ "        ?book <http://purl.org/dc/elements/1.1/creator> ?x ."
				+ "        ?book <http://purl.org/dc/elements/1.1/title> ?title .}" ;
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		try {
			
		    ResultSet results = qexec.execSelect() ;
		    
		    for ( ; results.hasNext() ; ) {
		    	QuerySolution soln = results.nextSolution() ;
		    	//RDFNode x = soln.get("title") ;       // Get a result variable by name.
		    	System.out.println(soln.getLiteral("title"));
		    	//soln.varNames().forEachRemaining(s -> System.out.print(s));
		    	
//		      Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
//		      Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
		   
		    }
		  
		} finally { 
			  qexec.close() ;
		}
		
		model.write(System.out, "N-TRIPLE");
//		model.write(System.out, "RDF/XML-ABBREV");
		

	}

}
