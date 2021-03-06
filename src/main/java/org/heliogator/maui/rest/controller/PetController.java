package org.heliogator.maui.rest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.heliogator.maui.entity.Pet;
import org.heliogator.maui.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/pet")
@RestController
public class PetController {

    private static final Logger LOG = LogManager.getLogger(PetController.class);
    
    @Autowired
    PetService service;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Pet findPet(@PathVariable String name) {
        LOG.debug("finding pet: " + name);
        
        return service.findPet(name);
    }
}
