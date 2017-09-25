package org.heliogator.maui.service;

import org.heliogator.maui.MauiMainTest;
import org.heliogator.maui.entity.Owner;
import org.heliogator.maui.entity.Pet;
import org.heliogator.maui.repository.OwnerRepository;
import org.heliogator.maui.repository.PetRepository;
import org.heliogator.maui.rest.api.OwnerDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MauiMainTest.class})
public class OwnerServiceTest {

    @Autowired
    OwnerService ownerService;

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Before
    public void beforeTest() {
        Owner testOwner = new Owner();
        testOwner.setName("Gene");

        Owner testOwner2 = new Owner();
        testOwner2.setName("Nikka");

        ownerRepository.save(Arrays.asList(testOwner, testOwner2));

        Pet testPet = new Pet();
        testPet.setName("Maui");
        testPet.setType("Cat");
        testPet.setOwner(testOwner);
        petRepository.saveAndFlush(testPet);
    }

    @After
    public void afterTest() {
        petRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    public void listOwners(){
        List<OwnerDetails> ownerDetailsList = ownerService.listOwners();
        ownerDetailsList.forEach(ownerDetails -> {
            String ownerName = ownerDetails.getOwner().getName();
            assertTrue((ownerName.equals("Gene") && ownerDetails.isHasPet())
                    || (ownerName.equals("Nikka") && !ownerDetails.isHasPet()));
        });
    }
}
