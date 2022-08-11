package com.conygre.spring.boot.service;

import com.conygre.spring.boot.entities.CompactDisc;
import com.conygre.spring.boot.repos.CompactDiscRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CompactDiscServiceImpl implements CompactDiscService {

	@Autowired
	private CompactDiscRepository dao;


	public List<CompactDisc> getCatalog() {
		return (List<CompactDisc>)dao.findAll();
	}
}


