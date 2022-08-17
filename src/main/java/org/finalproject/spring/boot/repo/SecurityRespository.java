package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Security;
import org.springframework.data.repository.CrudRepository;

public interface SecurityRespository extends CrudRepository<Security,Integer> {
}
