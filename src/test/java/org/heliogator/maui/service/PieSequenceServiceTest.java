package org.heliogator.maui.service;

import org.heliogator.maui.MauiMainTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MauiMainTest.class)
public class PieSequenceServiceTest {
    @Autowired
    PieSequenceService service;
    
    @Test
    public void countPrimes() {
        assertEquals(3,service.countPrimes(6));
        assertEquals(25, service.countPrimes(100));
    }
    
    @Test
    public void createSequence() {
        List[] sequenceLists = service.getPieSequence(10);
        List<Long> firstSequence = Arrays.asList(10L, 4L);
        List<Long> secondSequence = Arrays.asList(10L, 4L, 2L);
        List<Long> thirdSequence = Arrays.asList(10L, 4L, 2L, 1L);
        List[] expectedSequences = {firstSequence, secondSequence, thirdSequence};
        
        assertTrue(Arrays.equals(sequenceLists, expectedSequences));
        
    }
    
    @Test
    public void countNonPrimes() {
        long nonPrimes = service.countNonPrimes(new Long[]{10L, 4L, 2L, 1L});
        assertEquals(2, nonPrimes);
    }
}
