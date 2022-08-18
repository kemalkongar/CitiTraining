package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Security;

public interface SecurityService {

	Iterable<Security> getSecurities();

	Security getSecurityByName(String name);

	Security getSecurityByTicker(String ticker);

	Security getSecurityById(int id);

	Security setSecurityPriceByName(String name, double newPrice);

	Security setSecurityPriceByTicker(String name, double newPrice);

	void deleteSecurity(int id);

}