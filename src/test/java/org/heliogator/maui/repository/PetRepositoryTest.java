package org.heliogator.maui.repository;

import org.heliogator.maui.MauiMainTest;
import org.heliogator.maui.entity.Owner;
import org.heliogator.maui.entity.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MauiMainTest.class)
public class PetRepositoryTest {

    private final long testPetId = 0L;

    private final long testOwnerId = 0L;

    @Autowired
    PetRepository repository;

    @Autowired
    OwnerRepository ownerRepository;

    @Before
    public void beforeTest() {

        Owner owner = new Owner();
//        owner.setId(testOwnerId);
        owner.setName("Nikka");
        ownerRepository.save(owner);

        Pet pet = new Pet();
//        pet.setId(testPetId);
        pet.setName("Maui");
        pet.setType("Cat");
        pet.setOwner(owner);

        repository.saveAndFlush(pet);
    }

    @After
    public void afterTest() {
        repository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    public void findOne() {
        Pet pet = repository.findByName("Maui");
        assertNotNull(pet);
        Owner owner = pet.getOwner();
        assertNotNull(owner);
    }

    @Test
    public void findByOwnerName() {
        List<Pet> pets = repository.findByOwnerName("Nikka");
        pets.forEach(pet -> {
            assertEquals("Maui", pet.getName());
            Owner owner = pet.getOwner();
            assertEquals("Nikka", owner.getName());
        });
    }

    @Test
    public void addPrimes() {

    }
}
