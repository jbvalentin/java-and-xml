package jaxb.testjaxb4mixed.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private String id;
	private String firstName;
	private String lastName;
	private int born;
	private int died;
	private String placeOfBirth;
	private String placeOfDeath;
	// private Notes notes;
	
	public String getId() {
		return id;
	}
	
	@XmlAttribute
	@XmlID
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	@XmlElement(name="firstname")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	@XmlElement(name="lastname")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the born
	 */
	public int getBorn() {
		return born;
	}
	/**
	 * @param born the born to set
	 */
	@XmlElement
	public void setBorn(int born) {
		this.born = born;
	}
	/**
	 * @return the died
	 */
	public int getDied() {
		return died;
	}
	/**
	 * @param died the died to set
	 */
	@XmlElement
	public void setDied(int died) {
		this.died = died;
	}
	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	@XmlElement(name="place-of-birth")
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	/**
	 * @return the placeOfDeath
	 */
	public String getPlaceOfDeath() {
		return placeOfDeath;
	}
	/**
	 * @param placeOfDeath the placeOfDeath to set
	 */
	@XmlElement(name="place-of-death")
	public void setPlaceOfDeath(String placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}
	
	@Override
	public String toString() {
		return id + "\t" + firstName + " " + lastName + " (" + born + ", " + placeOfBirth + " - " + died + ", " + placeOfDeath + ")";
	}

}
