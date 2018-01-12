package fr.canalplus.integration.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.canalplus.integration.common.beans.entities.Person;
import fr.canalplus.integration.common.services.interfaces.PersonDao;
import fr.canalplus.integration.common.services.interfaces.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);
		
	}

	@Override
	public void editPerson(Person person) {
		personDao.editPerson(person);
		
	}

	@Override
	public void deletePerson(Person person) {
		personDao.deletePerson(person);
		
	}

	@Override
	public Person findPerson(int personId) {
		return personDao.findPerson(personId);
	}

	@Override
	public List<Person> findAllPerson() {
		return personDao.findAllPerson();
	}

	
}
