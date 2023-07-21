package jaxb.testjaxb2.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listofpersons")
public class ListPerson {
	
	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {
		return persons;
	}

	@XmlElement(name="person")
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public String toString() {
		return Arrays.deepToString(persons.toArray());
	}
	
	
}
