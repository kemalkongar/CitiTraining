package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Security;

public interface SecurityService {
	
	Security getSecurityByName(String name);

	Security getSecurityByTicker(String ticker);

	Security getSecurityById(int id);

	Security setSecurityPrice(String name, double newPrice);

	Iterable <Security> getSecurities();

	void deleteSecurity(int id);

}