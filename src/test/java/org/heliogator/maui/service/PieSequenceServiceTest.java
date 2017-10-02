package org.heliogator.maui.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.heliogator.maui.MauiMainTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        List<List<Long>> sequenceLists = service.getPieSequences(10);
        List<List<Long>> expectedSequences = new ArrayList <>();
        List<Long> firstSequence = Arrays.asList(10L, 4L);
        expectedSequences.add(firstSequence);
        List<Long> secondSequence = Arrays.asList(10L, 4L, 2L);
        expectedSequences.add(secondSequence);
        List<Long> thirdSequence = Arrays.asList(10L, 4L, 2L, 1L);
        expectedSequences.add(thirdSequence);
        
        assertEquals(expectedSequences, sequenceLists);
        
    }
    
    @Test
    public void countNonPrimes() {
        long result = service.countNonPrimesForAllSequences(4);
        assertEquals(3L, result);
        result = service.countNonPrimesForAllSequences(10);
        assertEquals(648L , result);
        result = service.countNonPrimesForAllSequences(100);
        assertEquals(31038676032L, result);
        //        BigInteger bigInteger = new BigInteger(String.valueOf(100000000));
        //        result = service.countNonPrimesForAllSequences(bigInteger.longValue());
        //        System.out.print(result);
    }
}
