package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Security;
import org.finalproject.spring.boot.repo.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> listAllSecurities() {
        return securityRepository.findAll();
    }

    public Security getSecurityById(Integer id) {
        return securityRepository.getById(id);
    }

    public Security getSecurityByName(String name) {
        return securityRepository.getByName(name);
    }

    public Security getSecurityByTicker(String name) {
        return securityRepository.getByTicker(name);
    }

    public void saveSecurity(Security security) {
        securityRepository.save(security);
    }
}
