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
    public List<Holdings> getHoldingsBySecurityId(@PathVariable Integer security) {
        return holdingsService.getHoldingsBySecurityId(security);
    }

    @GetMapping("/lot/{lot}")
    public List<Holdings>  getHoldingsByLot(@PathVariable Integer lot) {
        return holdingsService.getHoldingsByLot(lot);
    }

    @GetMapping("/buyPrice/{min}/{max}")
    public List<Holdings>  findByBuyPriceBetween(@PathVariable double min, @PathVariable double max){
        return holdingsService.findByBuyPriceBetween(min,max);
    }

    @PostMapping("/addHoldings")
    public void addHoldings(@RequestBody Holdings security) {
        holdingsService.saveHoldings(security);
    }
}
