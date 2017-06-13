package info.listopad.entry.unique;

// not exactly http://judy.sourceforge.net/index.html but intended to be close. (LGPL[[[[...)
// reminiscent of [Trove?] IntSet too

import java.util.LinkedList;
import java.util.List;

public class Narnia { // todo extract interface
	
	// [key / ratio] | [count]
	final List<int[]> backing = new LinkedList<int[]>();
	final Primes primes;
	final Growth growth;

	public Narnia(Primes primes, Growth growth) {
		this.primes = primes;
		this.growth = growth;
	}

	/////
}
