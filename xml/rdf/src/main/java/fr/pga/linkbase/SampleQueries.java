package fr.pga.linkbase;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

public class SampleQueries {
	
	public static void displaydmInfo(String dmc, Model model) {
		String queryString = "SELECT ?r ?v "
				+ " WHERE { <http://s1000d.org/dm/" + dmc + "> ?r ?v . }" ;
		Query query = QueryFactory.create(queryString) ;
		
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		try {
			
		    ResultSet results = qexec.execSelect() ;
		    
		    for ( ; results.hasNext() ; ) {
		    	QuerySolution soln = results.nextSolution() ;
		    	//RDFNode x = soln.get("title") ;       // Get a result variable by name.
		    	System.out.println(soln.get("r")  +   "  |  "  + soln.get("v"));
		    	
		    	//soln.varNames().forEachRemaining(s -> System.out.print(s));
		    	
//		      Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
//		      Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
		   
		    }
		  
		} finally { 
			  qexec.close() ;
		}
	}
	
	
	public static void displayCallers(String dmc, Model model) {
		String queryString = "SELECT ?caller "
//				+ " WHERE { ?urn <" + org.apache.jena.vocabulary.DCTerms.hasVersion + "> <http://s1000d.org/dm/" + dmc + "> . "
//						+ " ?caller <" + org.apache.jena.vocabulary.DCTerms.references + "> ?urn }" ;
				+ " WHERE { <http://s1000d.org/dm/" + dmc + "> ^<"+ org.apache.jena.vocabulary.DCTerms.hasVersion+ ">/^<" + org.apache.jena.vocabulary.DCTerms.references + "> ?caller . }" ;
		System.out.println(" query " + queryString);
		Query query = QueryFactory.create(queryString) ;
		
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		try {
			
		    ResultSet results = qexec.execSelect() ;
		    if (!results.hasNext()) {
		    	System.err.println("Not found.");
		    }
		    for ( ; results.hasNext() ; ) {
		    	QuerySolution soln = results.nextSolution() ;
		    	//RDFNode x = soln.get("title") ;       // Get a result variable by name.
		    	System.out.println(soln.get("caller")  +   "  |  "  );
		    	
		    	//soln.varNames().forEachRemaining(s -> System.out.print(s));
		    	
//		      Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
//		      Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
		   
		    }
		  
		} finally { 
			  qexec.close() ;
		}
	}

}
