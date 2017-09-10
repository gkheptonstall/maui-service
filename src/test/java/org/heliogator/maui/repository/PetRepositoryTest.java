package org.heliogator.maui.repository;

import org.heliogator.maui.MauiMain;
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
@ContextConfiguration(classes = MauiMain.class)
public class PetRepositoryTest {

    private final long testPetId = 999999999L;

    @Autowired
    PetRepository repository;

    @Before
    public void beforeTest() {

        Pet pet = new Pet();
        pet.setId(999999999L);
        pet.setName("Maui");
        pet.setType("Cat");

        repository.saveAndFlush(pet);
    }

    @After
    public void afterTest() {
        repository.delete(testPetId);
    }

    @Test
    public void findOne() {
        Pet pet = repository.findOne(testPetId);
        assertNotNull(pet);
    }
}
