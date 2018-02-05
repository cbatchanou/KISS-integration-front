package fr.canalplus.integration.common.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.canalplus.integration.common.beans.entities.Person;
import fr.canalplus.integration.common.beans.entities.Subscriber;
import fr.canalplus.integration.common.services.interfaces.PersonDao;
import fr.canalplus.integration.common.services.interfaces.SubscriberDao;

@Repository
@Qualifier("subscriberDao")
@PropertySource("classpath:configurations/sqlQueries.properties")
public class SubscriberDaoImpl implements SubscriberDao, PersonDao {

	@Autowired
	@Qualifier("cgaTemplate")
	JdbcTemplate cgaTemplate;
	
	
	@Value("${SQL_FIND_SUBSCRIBER}")
	private String sql_find_subscriber;
	
	
	@Override
	public void addSubscriber(Subscriber subscriber) {

	}

	@Override
	public List<Subscriber> findAllSubscriber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscriber find(Integer numAbo) {
		Subscriber subscriber = (Subscriber) cgaTemplate.queryForObject(sql_find_subscriber, new Object[] {numAbo}, new BeanPropertyRowMapper<Subscriber>(Subscriber.class));
		return subscriber;
	}

	@Override
	public Map<String, String> getElements() {
		// TODO Auto-generated method stub
		Map<String, String> rows = null;
		String sql = "select * from abo_abonn, ABO_PHONES where ABO_PHONES.numabo=abo_abonn.NUMANO and ROWNUM <=1";
		rows.entrySet().add((Entry<String, String>) cgaTemplate.queryForList(sql));
		return rows;
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAllPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
