package fr.pga.linkbase;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.OWL2;
import org.apache.jena.vocabulary.RDFS;


public class CreateLinkBase {

	public static void main(String[] args) {
		
		Path p = Paths.get("D:/Temp/7_LivraisonAirbusMars2014/DDN-AJ-844BB-FAJ24-2014-50079");
//		Path p = Paths.get("Y:/DDN-AJ-844BB-FAJ24-2014-50019");
		
		//p.forEach(path -> System.out.println(path.getFileName()));

		Stream.Builder<Path> pStreamBuilder = Stream.builder();
		
		try {
			Files.walkFileTree(p, new FileVisitor<Path>() {

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					return FileVisitResult.CONTINUE;
				}
//				Y:\DME-844BB-FAJ24-AJ-A-21-51-31-04AAA-720A-A_002-00.XML
//				Y:\DME-844BB-FAJ24-AJ-A-07-50-03-24ZZZ-030Z-A_003-00.XML

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (file.toFile().toString().endsWith(".XML")) {
						//System.out.println(file.toFile().toString());
						pStreamBuilder.add(file);
					} else {
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}
				
			});
			//pStreamBuilder.build().forEach(path -> System.out.println(path.getFileName()));
			final Model model = ModelFactory.createDefaultModel();
			model.setNsPrefix("s1000d", "http://s1000.org/");
			//Property pRef = new PropertyImpl("http://s1000.org/schemas/ref");
			
			pStreamBuilder.build().forEach(path -> {
//				System.out.println(path.getFileName()); 
				ParseXMLDocS1000D parse = new ParseXMLDocS1000D(path); 
				parse.startParseDocument(); 
				String dmUri = "http://s1000d.org/dm/" + parse.getValue(ParseXMLDocS1000D.TagContent.DCIDENTIFIER);
				final Resource dmRes = model.createResource(dmUri)
						.addProperty(DC_11.title, parse.getValue(ParseXMLDocS1000D.TagContent.DCTITLE), XSDDatatype.XSDstring)
						.addProperty(DC_11.date, parse.getValue(ParseXMLDocS1000D.TagContent.DCDATE), XSDDatatype.XSDdate)
						//.addProperty(RDFS.subClassOf, "")
						;
				for (String ref : parse.getRefs()) {
					//dmRes.addProperty(org.apache.jena.vocabulary.DCTerms.references, ref, XSDDatatype.XSDanyURI);
					dmRes.addProperty(org.apache.jena.vocabulary.DCTerms.references, model.createResource(ref));
					
				}
				if ("dmodule".equals(parse.getContentType())) {
					String s1000dURI = "URN:S1000D:DMC-" + 
							parse.getValue(ParseXMLDocS1000D.TagContent.IDSTATUS_DMC).replaceAll("(.{2})(.)(.{2})(.{2})(.{2})(.{5})(.{4})(.)", "$1-$2-$3-$4-$5-$6-$7-$8");
					model.createResource(s1000dURI).addProperty(org.apache.jena.vocabulary.DCTerms.hasVersion, dmRes);
				}
				
			});
			
			
			System.out.println("Query display info:");
			SampleQueries.displaydmInfo("844BB_FAJ24_AJ-A-32-33-58-09ZZZ-921Z-B_001-00", model);
			
			System.out.println("Query display callers:");
			SampleQueries.displayCallers("844BB_FAJ24_AJ-A-32-11-76-00ZZZ-231Z-B_001-00", model);
			
			
			// RDF/XML, N-TRIPLE, RDF/XML-ABBREV
			//model.write(System.out, "N-TRIPLE");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
