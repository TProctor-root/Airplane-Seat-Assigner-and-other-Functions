public class Airplane {
	public static final int FIRST = 0;
	public static final int ECONOMY = 1;

	public static final int FIRST_CLASS_ROWS = 5;
	public static final int ECONOMY_CLASS_ROWS = 15;

	public static final int SEATS_IN_FIRST_CLASS_ROW = 4;
	public static final int SEATS_IN_ECONOMY_CLASS_ROW = 6;
	
	private SeatRow[] a;
	private SeatRow[] b;

	public Airplane() {
		b = new SeatRow[ECONOMY_CLASS_ROWS];
		a = new SeatRow[FIRST_CLASS_ROWS];
		int k = 0;
		int j = 0;
		
		while(b.length > k) {
			b[k] = new SeatRow(SEATS_IN_ECONOMY_CLASS_ROW);
			k++;			
		}		
		while(a.length > j) {
			a[j] = new SeatRow(SEATS_IN_FIRST_CLASS_ROW);
			j++;
		}
	}

	public boolean addPassengers(int tclass, int npassenger, int where) {
		int k = 0;
		int j = 0;
		
		if (ECONOMY == tclass) {
			while(b.length > k) {
				if (b[k].addPassengers(npassenger, where)) {
		            return true;  
		        }
				k++;
			}
		}
		else if (FIRST == tclass) {
			while(a.length > j) {
				if (a[j].addPassengers(npassenger, where)) {
		            return true; 
		        }
				j++;
			}
		}
		return false;    
	}

	public String toString() {
		String z = "";
		int k = 0;
		int j = 0;
		
		while(a.length > j) {
			int v = j + 1;
		    if (10 > v) {
		        z = z + " ";
		    }
		    z = z + v + " ";
		    z = z + a[j].toString() + "\n";
			j++;
		}
		while(b.length > k) {
			int y = FIRST_CLASS_ROWS + k + 1;
		    if (10 > y) {
		        z = z + " ";
		    }
		    z = z + y + " ";
		    z =  z + b[k].toString() + "\n";
			k++;
		}
		return z;
	}
}