public class SeatRow {
	public static final int WINDOW = 0;
	public static final int CENTER = 1;
	public static final int AISLE = 2;

	private boolean[] available;
	private int more = 0;
	
	public SeatRow(int numSeats) {
		available = new boolean[numSeats];
	}

	public boolean addPassengers(int np, int p) {
		int s = available.length;
		
		if ((2 < np || CENTER == p) && 6 > s) {
		    return false;
		}
		if (CENTER == p && 3 == np) {
		    p = WINDOW;
		}
		if (CENTER == p) {
			more = 0;
			return add(1 - np + 1, 1) || add(1, 1 + np - 1)|| add(4, 4 + np - 1) || add(4 - np + 1, 4);
		}
		else if (AISLE == p) {
			more++;
			if(more == 5) {
				more = 0;
				return add(s / 2 - np, s / 2 - 1) || add(s / 2, s / 2 + np - 1);
			}
			else if(more > 2) {
				return add(0, np - 1) || add(s - np, s - 1);
			}
			
			else {
				return add(s / 2 - np, s / 2 - 1) || add(s / 2, s / 2 + np - 1);
			}
		}
		else if (WINDOW == p) {
			more = 0;
			return add(0, np - 1) || add(s - np, s - 1);
		}
		return false;
	}

	public boolean add(int from, int to) {
		int k = from;
		int j = from;
		
		while(to >= k) {
			if (available[k]) {
		        return false;
		    }
			k++;
		}
		while(to >= j) {
			available[j] = true;
			j++;
		}
		return true;
	}
	
	public String toString() {
		String a = "[";
		int z = 0;
		int sz = available.length;
		
		while(sz > z) {
			if (available[z]) {
		        a = a + "*";
		    }
		    else {
		        a = a + ".";
		    }
		    if (sz == 4 || sz == 6 && z == 2) {
		    	if((sz == 4 && z == 3) || (sz == 6 && z == 5)) {
		    
		    	}
		    	else {
		    		a = a + " "; 
		    	}
		    }
			z++;
		}	
		a = a + "]";
		return a;
	}
}