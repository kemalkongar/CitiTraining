package org.finalproject.spring.boot.service;




import org.finalproject.spring.boot.entities.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.finalproject.spring.boot.repo.SecurityRespository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private SecurityRespository dao;


	@Override
	public Security getSecurityByName(String name){
		return null;
	}

	@Override
	public Security getSecurityByTicker(String ticker) {
		return null;
	}

	@Override
	public Security getSecurityById(int id) {
		return null;
	}

	@Override
	public Security setSecurityPrice(String name, double newPrice){
		return null;
	}

	@Override
	public void deleteSecurity(int id){

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Iterable<Security> getSecurities() {

		return dao.findAll();
	}
}
