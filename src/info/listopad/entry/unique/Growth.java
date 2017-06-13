package info.listopad.entry.unique;

/**
 * Defines growth policy (e.g. allocate in close-sized or growing-sized chunks).
 */
public interface Growth {
	int next(int prev);
	
	enum Predefined implements Growth {
		SUBSEQUENT {
			@Override
			public int next(int prev) {
				return prev + 2;
			}
		},
		EXPONENTIAL {
			@Override
			public int next(int prev) {
				return prev * 2;
			}
		}
	}
}
