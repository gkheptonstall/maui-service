package org.heliogator.maui.service;

import org.heliogator.maui.MauiMainTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MauiMainTest.class)
public class PetServiceTest {

    @Autowired
    PetService service;

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
}
