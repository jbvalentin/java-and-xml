package sax.filter2;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import sax.generic.GenericContentHandler;

public class MainCascadeFilters {

	public static void main(String[] args) {
		String xmlFile = "C:\\temp\\Renodoc_Defaut\\A400M\\remarquesNP_DR\\fradRepository.rem";
		//String xmlFile = "C:\\Work\\Projets\\5700331-Renodoc\\700-SVN\\RenodocFA\\pom.xml";
		
		//File f = new File(xmlFile);
		XMLFilter fiFirst = new FilterImplFirstLevel();
		XMLFilter fiSecond = new FilterImplSecondLevel();
		
		try {
			XMLReader r = XMLReaderFactory.createXMLReader();
			
			fiSecond.setParent(fiFirst);
			fiFirst.setParent(r);
			
			fiSecond.setContentHandler(new GenericContentHandler());
			
			//System.out.println(r.getClass().getName());
			fiSecond.parse(xmlFile);
			
			//fi.parse(xmlFile);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (SAXException e) {
			e.printStackTrace(System.err);
		}

	}

}
