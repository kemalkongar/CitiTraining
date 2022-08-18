package org.finalproject.spring.boot.controller;
//import org.apache.log4j.Logger;

import io.swagger.annotations.ApiOperation;
import org.finalproject.spring.boot.entities.Security;
import org.finalproject.spring.boot.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/securities")
@ComponentScan("org.finalproject.spring.boot")
@CrossOrigin
public class SecurityController {

    @Autowired
    private SecurityService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Security securityTest() {
        Security testSec = new Security("test", "testSecurity", "testEx", 0);
        return testSec;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Iterable<Security> getAll() {
        return service.getSecurities();
    }
}
