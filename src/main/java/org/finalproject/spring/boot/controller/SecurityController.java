package org.finalproject.spring.boot.controller;
//import org.apache.log4j.Logger;

import org.finalproject.spring.boot.entities.Security;
import org.finalproject.spring.boot.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/securities")
@ComponentScan("org.finalproject.spring.boot")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class SecurityController {

    @Autowired
    SecurityService securityService;


    @GetMapping("/")
    public List<Security> list() {
        return securityService.listAllSecurities();
    }

    @GetMapping("/{id}")
    public Security getSecurityById(@PathVariable Integer id) {
        return securityService.getSecurityById(id);
    }

    @GetMapping("/ticker/{ticker}")
    public Security nameTest(@PathVariable String ticker) {
        return securityService.getSecurityByTicker(ticker);
    }

    @PostMapping(value = "/addSecurity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSecurity(@RequestBody Security security) {
        securityService.saveSecurity(security);
    }
}
