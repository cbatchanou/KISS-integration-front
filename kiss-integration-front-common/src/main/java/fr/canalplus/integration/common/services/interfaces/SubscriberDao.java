/**
 * 
 */
package fr.canalplus.integration.common.services.interfaces;

import java.util.List;
import java.util.Map;

import fr.canalplus.integration.common.beans.entities.Subscriber;

/**
 * @author cbatchanou
 *
 */
public interface SubscriberDao {

	public void addSubscriber(Subscriber subscriber);
	
	public List<Subscriber> findAllSubscriber();
	
	public Subscriber find(Integer numAbo);
	
	public Map<String, String> getElements();
}
