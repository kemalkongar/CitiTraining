package org.finalproject.spring.boot.controller;
//import org.apache.log4j.Logger;

import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.service.HoldingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@ComponentScan("org.finalproject.spring.boot")
@CrossOrigin
public class HoldingsController {

    @Autowired
    HoldingsService holdingsService;


    @GetMapping("/")
    public List<Holdings> list() {
        return holdingsService.listAllHoldings();
    }

    @GetMapping("/{id}")
    public Holdings getHoldingsById(@PathVariable Integer id) {
        return holdingsService.getHoldingsById(id);
    }

    @GetMapping("/security/{security}")
    public Holdings getHoldingsBySecurity(@PathVariable Integer security) {
        return holdingsService.getHoldingsBySecurity(security);
    }

    @GetMapping("/security/ticker/{security_ticker}")
    public Holdings getHoldingsBySecurityTicker(@PathVariable String security_ticker) {
        return holdingsService.getHoldingsBySecurityTicker(security_ticker);
    }

    @GetMapping("/security/name/{security_name}")
    public Holdings getHoldingsBySecurityName(@PathVariable String security_name) {
        return holdingsService.getHoldingsBySecurityName(security_name);
    }

    @GetMapping("/buyPrice/{min}/{max}")
    public List<Holdings>  findByBuyPriceBetween(@PathVariable double min, @PathVariable double max){
        return holdingsService.findByBuyPriceBetween(min,max);
    }

    @PostMapping(value = "/addHoldings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addHoldings(@RequestBody Holdings security) {
        holdingsService.saveHoldings(security);
    }
}
