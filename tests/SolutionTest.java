import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;

public class SolutionTest {
    @Test
    public void basicTests() {
        assertEquals(Arrays.asList(22, 25, 27, 32, 33, 35, 52, 55, 57, 72, 75, 77), Solution.notPrimes(   2,  222));
        assertEquals(Arrays.asList(2722, 2723, 2725, 2727, 2732, 2733, 2735, 2737, 2752, 2755, 2757, 2772, 2773, 2775), Solution.notPrimes(2700, 3000));
        assertEquals(Arrays.asList(522, 525, 527, 532, 533, 535, 537, 552, 553, 555, 572, 573, 575, 722, 723, 725, 732, 735, 737, 752, 753, 755, 772, 775, 777), Solution.notPrimes( 500,  999));
        assertEquals(Arrays.asList(2222, 2223, 2225, 2227, 2232, 2233, 2235, 2252, 2253, 2255, 2257, 2272, 2275, 2277, 2322, 2323, 2325, 2327, 2332, 2335, 2337, 2352, 2353, 2355, 2372, 2373, 2375), Solution.notPrimes( 999, 2500));
    }
    @Test
    public void smallRandomTests() {
        for (int i = 0; i < 200; i++) {
            int a = randomInt(   2,   100),
                    b = randomInt(1500, 20000);
            assertEquals(this.notPrimes(a, b), Solution.notPrimes(a, b));
        }
    }
    @Test
    public void largeRandomTests() {
        for (int i = 0; i < 1000; i++) {
            int a = randomInt(    2, 16000),
                    b = randomInt(16000, 20000);
            assertEquals(this.notPrimes(a, b), Solution.notPrimes(a, b));
        }
    }
    private int randomInt(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    private boolean isPrime(int n) {
        if ( 2 == n ) return true;
        if ( n < 2 || n % 2 == 0 ) return false;
        for (int x = 3; x <= Math.sqrt(n); x += 2)
            if ( n % x == 0 )
                return false;
        return true;
    }
    public List<Integer> notPrimes(int a, int b) {
        List<Integer> nonPrimes = new ArrayList<Integer>();
        for (int n = a; n < b; n++)
            if ( !isPrime(n) ) {
                boolean primeDigits = true;
                for (char d : String.valueOf(n).toCharArray())
                    if ( "2357".indexOf(d) < 0 ) {
                        primeDigits = false;
                        break;
                    }
                if ( primeDigits )
                    nonPrimes.add(n);
            }
        return nonPrimes;
    }
}