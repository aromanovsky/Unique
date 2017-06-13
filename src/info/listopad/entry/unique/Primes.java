package info.listopad.entry.unique;

/**
 * Generator of prime numbers.
 */
public interface Primes {
	int atLeast(int lowerBound);
	// we don't need "next()" because it would have rendered the generator stateful
}
