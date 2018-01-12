package fr.canalplus.integration.common.beans.entities;

public class Person {
	
	private String civility;
	private String firstName;
	private String lastName;
	private Long personId;
	private String segmentation;
	private String subscriberCategory;
	private String bithDate;
	private String email;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCivility() {
		return civility;
	}
	public void setCivility(String civility) {
		this.civility = civility;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getSegmentation() {
		return segmentation;
	}
	public void setSegmentation(String segmentation) {
		this.segmentation = segmentation;
	}
	public String getSubscriberCategory() {
		return subscriberCategory;
	}
	public void setSubscriberCategory(String subscriberCategory) {
		this.subscriberCategory = subscriberCategory;
	}
	public String getBithDate() {
		return bithDate;
	}
	public void setBithDate(String bithDate) {
		this.bithDate = bithDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
