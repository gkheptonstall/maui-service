package org.heliogator.maui.controller;

import org.heliogator.maui.rest.api.OwnerDetails;
import org.heliogator.maui.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/owner")
@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OwnerDetails> listOwners() {
        return ownerService.listOwners();
    }
}
