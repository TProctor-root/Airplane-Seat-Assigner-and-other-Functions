import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class AirportData {
	
	class Information {
		private int a;
		private String b;
		private String c;
		
		public Information(int one, String two, String three) {
			a = one;
			b = two;
			c = three;
		}
		public int getA() {
			return a;
		}
		public String getB() {
			return b;
		}
		public String getC() {
			return c;
		}
	}	
	
	private ArrayList<Information> z;
	
	AirportData(String dataFileName) {
		z = new ArrayList<Information>();
		String line;
		String[] gap;
		try(Scanner inFile = new Scanner(new File(dataFileName))) {
			while(inFile.hasNext()) {
				line = inFile.nextLine();
				line = line.replaceAll("\"", "");
				gap = line.split(",");
				z.add(new Information(Integer.parseInt(gap[0]), gap[1], gap[2]));
			}
			inFile.close();
		} catch(FileNotFoundException e) {
			System.out.println("File: " + dataFileName + " not found");
		}
	}
	
	ArrayList<String> getAllAirportsInCity(String cityName) {
		ArrayList<String> x = new ArrayList<String>();
		for(int i = 0; i < z.size(); i++) {
			if(z.get(i).getC().equalsIgnoreCase(cityName)) {
				x.add(z.get(i).getB());
			}
		}
		return x;	
	}
} 