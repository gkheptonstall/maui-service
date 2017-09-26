package org.heliogator.maui.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PieSequenceService {
    
    public long countPrimes(long maxNum) {
        long numberOfPrimes = 0;
        for (long i = maxNum; i > 1; i--) {
            if (i == 2 || (i % 2 != 0 && isPrime(i))) {
                numberOfPrimes++;
            }
        }
        
        return numberOfPrimes;
    }

    private boolean isPrime(long test) {
        boolean isPrime = true;
        if (test > 2) {
            for (long i = test - 1; i > 1; i--) {
                if (test % i == 0) {
                    isPrime = false;
                }
            }
        } else if (test == 1) {
            isPrime = false;
        }
        return isPrime;
    }
    
    public List<List<Long>> getPieSequences(long startNum) {
        List<List<Long>> sequenceLists = new ArrayList<>();
        List<Long> sequenceList = new ArrayList<>();
        long currentNum = startNum;
        while (currentNum > 1) {
            sequenceList.add(currentNum);
            if (sequenceList.size() >= 2) {
                sequenceLists.add(sequenceList);
                sequenceList = new ArrayList<>(sequenceList);
            }
            currentNum = countPrimes(currentNum);
        }
        sequenceList.add(1L);
        sequenceLists.add(sequenceList);
        return sequenceLists;
    }
    
    public long countNonPrimes(List<Long> pieSequence) {
        long nonPrimes = 0;
        for (Long number : pieSequence) {
            if (!isPrime(number)) {
                nonPrimes++;
            }
        }
        return nonPrimes;
    }
    
    public long countNonPrimesForAllSequences(long maxFirstNum) {
        Map<Long, Long> sequenceNonPrimesMap = new HashMap<>();
        for (long i = 2; i <= maxFirstNum; i++) {
            List<List<Long>> sequences = getPieSequences(i);
            for (List<Long> sequence : sequences) {
                long nonPrimes = countNonPrimes(sequence);

                Long sequenceCount = sequenceNonPrimesMap.get(nonPrimes);
                if (sequenceCount == null) {
                    sequenceNonPrimesMap.put(nonPrimes, 1L);
                } else {
                    sequenceNonPrimesMap.put(nonPrimes, ++sequenceCount);
                }

            }
        }
        
        long total = 0;
        for (Map.Entry<Long, Long> entry : sequenceNonPrimesMap.entrySet()) {
            if (total == 0) {
                total = entry.getValue();
            } else {
                total = total * entry.getValue();
            }
        }
        return total;
    }
}
