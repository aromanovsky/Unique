package info.listopad.entry.unique;

import java.util.Arrays;
/**
 * An extremely lazy implementation of Primes.
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Incremental_sieve
 */
public class Eratosthenes implements Primes {

	// TODO expose a thread-safe implementation or facade
	
	private int[] harvest = {
			2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
			41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
			83, 89, 97, 101, 103, 107, 109, 113, 127,
			131, 137, 139, 149, 151, 157, 163, 167,
			173, 179, 181, 191, 193, 197, 199, 211,
			223, 227, 229, 233, 239, 241, 251, 257,
			263, 269, 271, 277, 281, 283, 293, 307,
			311, 313, 317, 331, 337, 347, 349, 353,
			359, 367, 373, 379, 383, 389, 397, 401,
			409, 419, 421, 431, 433, 439, 443, 449,
			457, 461, 463, 467, 479, 487, 491, 499,
			503, 509, 521, 523, 541, 547, 557, 563,
			569, 571, 577, 587, 593, 599, 601, 607,
			613, 617, 619, 631, 641, 643, 647, 653,
			659, 661, 673, 677, 683, 691, 701, 709,
	};
	
	private int nextPrimeIndex = harvest.length, lastPrimeFound = harvest[nextPrimeIndex - 1];

	@SuppressWarnings("UnnecessaryLabelOnBreakStatement") // I like clarity
	@Override
	public int moreThan(int value) {
		int tested = lastPrimeFound;
		if (value >= lastPrimeFound) { // optimization 1
			candidate: while (value >= lastPrimeFound) {
				++tested;
				foundPrimes: for (int prime : harvest) {
					if (prime * prime > tested) {
						break foundPrimes;
					}
					if (tested % prime == 0) {
						continue candidate;
					}
					if (prime == lastPrimeFound) {
						break foundPrimes;
					}
				}
				if (nextPrimeIndex == harvest.length) {
					grow();
				}
				harvest[nextPrimeIndex++] = lastPrimeFound = tested;
			}
			return lastPrimeFound; // optimization 1
		}
		return ceilInFound(value);
	}

	private void grow() {
		final int[] newHarvest = new int[harvest.length * 2];
		System.arraycopy(harvest, 0, newHarvest, 0, nextPrimeIndex);
		harvest = newHarvest;
	}

	private int ceilInFound(int value) {
		int idxOrIns = Arrays.binarySearch(harvest, 0, nextPrimeIndex, value + 1);
		return idxOrIns >= 0 ? harvest[idxOrIns] : harvest[~idxOrIns];
	}
}
