package fr.canalplus.front.bdd.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

import fr.canalplus.integration.common.services.interfaces.BeanInterface;

public class BeanClassPostProcessor implements BeanPostProcessor, PriorityOrdered {

	private int order;

	@Override
	public int getOrder() {
		return order;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof BeanInterface) {
			((BeanInterface) bean).doSomething();
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException{
	
	}
}
