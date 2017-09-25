package org.heliogator.maui.service;

import org.heliogator.maui.entity.Owner;
import org.heliogator.maui.repository.OwnerRepository;
import org.heliogator.maui.repository.PetRepository;
import org.heliogator.maui.rest.api.OwnerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    public List<OwnerDetails> listOwners() {
        List<Owner> ownerList = ownerRepository.findAll();
        List<OwnerDetails> ownerDetailsList = new ArrayList<>();
        ownerList.forEach(owner -> {
            OwnerDetails ownerDetails = new OwnerDetails();
            ownerDetails.setOwner(owner);
            ownerDetails.setHasPet(petRepository.findByOwnerName(owner.getName()).size() > 0);
            ownerDetailsList.add(ownerDetails);
        });
        return ownerDetailsList;
    }
}
