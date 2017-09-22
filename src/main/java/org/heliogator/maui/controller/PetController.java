package org.heliogator.maui.controller;

import org.heliogator.maui.entity.Pet;
import org.heliogator.maui.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    //    private static final Logger LOG = LogManager.getLogger(PetController.class);
    @Autowired
    PetService service;

    @RequestMapping(value = "/pet/{name}", method = RequestMethod.GET)
    public Pet findPet(@PathVariable String name) {
        System.out.print(name);
        return service.findPet(name);
    }
}