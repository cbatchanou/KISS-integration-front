package fr.canalplus.integration.common.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.canalplus.integration.common.beans.entities.Subscriber;
import fr.canalplus.integration.common.services.interfaces.SubscriberDao;
import fr.canalplus.integration.common.services.interfaces.SubscriberService;

@Service("subscriberService")
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	SubscriberDao subscriberDao;
	
	@Override
	public void addSubscriber(Subscriber subscriber) {
		subscriberDao.addSubscriber(subscriber);
	}

	@Override
	public List<Subscriber> findAllSubscriber() {
		return subscriberDao.findAllSubscriber();
	}

	@Override
	public Subscriber find(Integer numAbo) {
		return subscriberDao.find(numAbo);
	}

	@Override
	public Map<String, String> getElements() {
		return subscriberDao.getElements();
	}

}
