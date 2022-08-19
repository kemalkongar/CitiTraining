package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.repo.HoldingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HoldingsService {
    @Autowired
    private HoldingsRepository holdingsRepository;

    public List<Holdings> listAllHoldings() {
        return holdingsRepository.findAll();
    }

    public Holdings getHoldingsById(Integer id) {
        return holdingsRepository.getById(id);
    }

    public Holdings getHoldingsBySecurityId(Integer security) {
        return holdingsRepository.getBySecurity(security);
    }

    public Holdings getHoldingsByLot(Integer lot) {
        return holdingsRepository.getByLot(lot);
    }

    public void saveHoldings(Holdings holdings) {
        holdingsRepository.save(holdings);
    }

}
