package fr.canalplus.integration.common.services.interfaces;

import java.util.List;

import fr.canalplus.integration.common.beans.entities.Person;

public interface PersonDao {

	public void addPerson(Person person);
	
	public void editPerson(Person person);
	
	public void deletePerson(Person person);
	
	public Person findPerson(int personId);
	
	public List<Person> findAllPerson();
}
