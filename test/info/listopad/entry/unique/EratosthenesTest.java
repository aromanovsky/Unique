package info.listopad.entry.unique;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Test the prime number generator.
 */
public class EratosthenesTest extends TestCase {
	
	private Primes primes;

	public void setUp() throws Exception {
		super.setUp();
		primes = new Eratosthenes();
	}

	public void testPrimes() throws Exception {
		int[] firstPrimes = new int[1024];
		int lastPrimeFound = 1;
		for (int i = 0; i < firstPrimes.length; ++ i) {
			lastPrimeFound = primes.moreThan(lastPrimeFound);
			for (int j = 0; j < i; ++j) {
				Assert.assertFalse("lastPrimeFound: " + lastPrimeFound, lastPrimeFound % firstPrimes[j] == 0);
			}
			firstPrimes[i] = lastPrimeFound;
		}
		Assert.assertEquals(2, firstPrimes[0]);
		Assert.assertEquals(3, firstPrimes[1]);
		Assert.assertEquals(5, firstPrimes[2]);
		Assert.assertEquals(7, firstPrimes[3]);
		Assert.assertEquals(23, firstPrimes[8]);
	}

	public void tearDown() throws Exception {
		primes = null;
		super.tearDown();
	}
}
