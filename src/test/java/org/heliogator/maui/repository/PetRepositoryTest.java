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
        owner.setId(testOwnerId);
        owner.setName("Nikka");
        ownerRepository.save(owner);

        Pet pet = new Pet();
        pet.setId(testPetId);
        pet.setName("Maui");
        pet.setType("Cat");
        pet.setOwner(owner);

        repository.saveAndFlush(pet);
    }

    @After
    public void afterTest() {
        repository.delete(testPetId);
        ownerRepository.delete(testOwnerId);
    }

    @Test
    public void findOne() {
        Pet pet = repository.findOne(testPetId);
        assertNotNull(pet);
        Owner owner = pet.getOwner();
        assertNotNull(owner);
    }

    @Test
    public void addPrimes() {

    }
}
