package org.heliogator.maui.service;

import org.heliogator.maui.entity.Owner;
import org.heliogator.maui.entity.Pet;
import org.heliogator.maui.repository.OwnerRepository;
import org.heliogator.maui.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;

    public Pet findPet(String petName) {
        Pet pet = petRepository.findByName(petName);
        if (pet == null) {

            Owner owner = new Owner();
            owner.setName("Nikka");
            ownerRepository.save(owner);

            pet = new Pet();
            pet.setName(petName);
            pet.setType("Cat");
            pet.setOwner(owner);

            petRepository.saveAndFlush(pet);
        }
        return petRepository.findByName(petName);
    }

    public long addPrimes(int maxNum) {
        long primeSum = 0;
        for (long i = 2L; i < maxNum; i++) {
            if (i < 4 || (i % 2 == 1 && isPrime(i))) {
                primeSum += i;
            }
        }
        return primeSum;
    }

    private boolean isPrime(long test) {
        for (long i = test - 1; i > 1; i--) {
            if (test % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long findFactorial(int numToFactorial) {
        long factorialSum = numToFactorial;
        for (long i = numToFactorial - 1; i > 1; i--) {
            factorialSum *= i;
        }
        String factorialSumStr = String.valueOf(factorialSum);
        factorialSum = 0L;
        for (char c : factorialSumStr.toCharArray()) {
            factorialSum += Long.parseLong(String.valueOf(c));
        }
        return factorialSum;
    }
}
