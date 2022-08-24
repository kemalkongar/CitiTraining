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

    public Holdings getHoldingsBySecurity(Integer security) {
        return holdingsRepository.getBySecurity(security);
    }

    public Holdings getHoldingsBySecurityTicker(String security_ticker) {
        return holdingsRepository.getBySecurityTicker(security_ticker);
    }

    public Holdings getHoldingsBySecurityName(String security_name) {
        return holdingsRepository.getBySecurityName(security_name);
    }

    public List<Holdings>  findByBuyPriceBetween(double min, double max) {return holdingsRepository.findByBuyPriceBetween(min, max);}

    public void saveHoldings(Holdings holdings) {
        holdingsRepository.save(holdings);
    }

}
