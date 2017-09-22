package org.heliogator.maui.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PieSequenceService {
    
    public long countPrimes(long maxNum) {
        long numberOfPrimes = 0;
        for (long i = 2; i < maxNum; i++) {
            if (i == 2 || (i % 2 != 0 && isPrime(i))) {
                numberOfPrimes++;
            }
        }
        
        return numberOfPrimes;
    }

    private boolean isPrime(long test) {
        for (long i = test - 1; i > 1; i--) {
            if (test % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public List[] getPieSequence(long startNum) {
        List<List<Long>> sequenceLists = new ArrayList<>();
        List<Long> sequenceList = new ArrayList<>();
        long currentNum = startNum;
        while (currentNum >= 1) {
            sequenceList.add(currentNum);
            if (sequenceList.size() >= 2) {
                sequenceLists.add(sequenceList);
                sequenceList = new ArrayList<>(sequenceList);
            }
            currentNum = countPrimes(currentNum);
        }
        sequenceList.add(1L);
        sequenceLists.add(sequenceList);
        return sequenceLists.toArray(new List[sequenceLists.size()]);
    }
    
    public long countNonPrimes(Long[] pieSequence) {
        long nonPrimes = 0;
        for (Long number : pieSequence) {
            if (!isPrime(number)) {
                nonPrimes++;
            }
        }
        return nonPrimes;
    }
}
