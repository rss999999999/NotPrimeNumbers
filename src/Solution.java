/*
You are given two positive integers a and b (a < b <= 20000).
Complete the function which returns a list of all those numbers in the interval [a, b)
whose digits are made up of prime numbers (2, 3, 5, 7) but which are not primes themselves.


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Arrays;

public class SampleTests {
    @Test
    public void basicTests() {
        assertEquals(Arrays.asList(22, 25, 27, 32, 33, 35, 52, 55, 57, 72, 75, 77), Solution.notPrimes(   2,  222));
        assertEquals(Arrays.asList(2722, 2723, 2725, 2727, 2732, 2733, 2735, 2737, 2752, 2755, 2757, 2772, 2773, 2775), Solution.notPrimes(2700, 3000));
        assertEquals(Arrays.asList(522, 525, 527, 532, 533, 535, 537, 552, 553, 555, 572, 573, 575, 722, 723, 725, 732, 735, 737, 752, 753, 755, 772, 775, 777), Solution.notPrimes( 500,  999));
        assertEquals(Arrays.asList(2222, 2223, 2225, 2227, 2232, 2233, 2235, 2252, 2253, 2255, 2257, 2272, 2275, 2277, 2322, 2323, 2325, 2327, 2332, 2335, 2337, 2352, 2353, 2355, 2372, 2373, 2375), Solution.notPrimes( 999, 2500));
    }
}

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> notPrimes(int a, int b) {
        // Create a list to store the non-prime numbers.
        List<Integer> notPrimes = new ArrayList<>();

        // Iterate over the numbers in the interval [a, b).
        for (int i = a; i < b; i++) {
            // Check if the number is prime.
            if (!isPrime(i)) {
                // Check if all of the digits in the number are prime.
                if (allDigitsPrime(i)) {
                    // Add the number to the list of non-prime numbers.
                    notPrimes.add(i);
                }
            }
        }

        // Return the list of non-prime numbers.
        return notPrimes;
    }

    // Checks if a number is prime.
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Checks if all of the digits in a number are prime.
    private static boolean allDigitsPrime(int n) {
        while (n > 0) {
            int digit = n % 10;

            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return false;
            }

            n /= 10;
        }

        return true;
    }
}