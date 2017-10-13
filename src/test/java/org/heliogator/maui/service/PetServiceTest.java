package org.heliogator.maui.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.heliogator.maui.MauiMainTest;
import org.heliogator.maui.entity.Owner;
import org.heliogator.maui.entity.Pet;
import org.heliogator.maui.repository.OwnerRepository;
import org.heliogator.maui.repository.PetRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MauiMainTest.class)
public class PetServiceTest {

    @Autowired
    PetService service;

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
    public void testAddPrimes() {
        long sum = service.addPrimes(10);
        assertEquals(17, sum);
    }

    @Test
    public void testFactorialSum() {
        long sum = service.findFactorial(10);
        assertEquals(27, sum);
    }

    @Test
    public void testFindPet() {
        Pet pet = service.findPet("Maui");
        assertNotNull(pet);
        Owner owner = pet.getOwner();
        assertNotNull(owner);
        assertEquals("Nikka", owner.getName());
    }

    @Test
    public void testFindNewPet() {
        String newPetName = "Chloe";
        assertNull(repository.findByName(newPetName));
        Pet newPet = service.findPet(newPetName);
        assertNotNull(newPet);
        Owner owner = newPet.getOwner();
        assertNotNull(owner);
        assertEquals("Nikka", owner.getName());
    }

    @Test
    public void testStringMatcher() {
        String testString = "ABCD TEST='12345' XYZ";
        boolean isMatch = testString.matches(".*TEST='.*'.*");
        assertTrue(isMatch);
        String newString = testString.replaceAll("TEST='.*'", "TEST='NEWSTRING'");
        assertEquals("ABCD TEST='NEWSTRING' XYZ", newString);
        String extractedString = newString.replaceAll(".*TEST='", "");
        assertEquals("NEWSTRING' XYZ", extractedString);
        extractedString = extractedString.replaceAll("'.*", "");
        assertEquals("NEWSTRING", extractedString);
    }
}
