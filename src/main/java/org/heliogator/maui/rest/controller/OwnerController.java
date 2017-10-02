package org.heliogator.maui.rest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.heliogator.maui.rest.api.OwnerDetails;
import org.heliogator.maui.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/owner")
@RestController
public class OwnerController {

    private static final Logger LOG = LogManager.getLogger(OwnerController.class);

    @Autowired
    OwnerService ownerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OwnerDetails> listOwners() {
        LOG.debug("listing owners");

        return ownerService.listOwners();
    }
}
