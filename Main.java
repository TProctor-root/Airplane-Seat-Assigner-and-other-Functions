import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void problem1_averageColumns(String inFileName, String outFileName) {
		double one = 0.0;
		double two = 0.0;
		int average = 0;
		String line;
		String[] gap;
		try(Scanner inFile = new Scanner(new File(inFileName))) {
			try(PrintWriter outFile = new PrintWriter(outFileName)) {
				while(inFile.hasNext()) {
					line = inFile.nextLine();
					gap = line.split("\\s+");
					one = one + Double.parseDouble(gap[0]);
					two = two + Double.parseDouble(gap[1]);
					average++;
				}
				outFile.println(one / average);
				outFile.println(two / average);
				inFile.close();
			}
		} catch(FileNotFoundException e) {
			System.out.println("File: " + inFileName + " not found");
		}
	}
	
	public static void main(String[] args) {
		problem1_averageColumns("columns.txt", "averages.txt");
		
		SpellChecker checker = new SpellChecker("words.txt");
		ArrayList notFoundWords = checker.checkFile("doc.txt"); 
		System.out.println(notFoundWords); 
		// prints: [foolishness, incredulity, Charles, A, I, havent, Christmas, Oliver] 
		
		AirportData ad = new AirportData("airports.dat");
		ArrayList<String> airports = ad.getAllAirportsInCity("Seoul"); 
		System.out.println(airports); 
		// prints [Gimpo International Airport, Incheon International Airport]
		airports = ad.getAllAirportsInCity("Irvine"); 
		System.out.println(airports); 
		// prints []
		
		Bank bank = new Bank();
		bank.readFile("accounts1.dat");
		BankAccount highest = bank.getHighestBalanceAccount(); 
		System.out.println(highest.getAccountNumber() + " " + highest.getBalance());
		bank.readFile("accounts2.dat");
		highest = bank.getHighestBalanceAccount(); 
		System.out.println(highest.getAccountNumber() + " " + highest.getBalance());
		
		/*
		The above prints:
		9 34897.0
		5 35000.98
		*/
		
		SalesTally st = new SalesTally("sales.txt"); 
		System.out.println(st.getCategoryTotal("Dinner")); 
		// prints 53.4
		System.out.println(st.getCategoryTotal("Conference")); 
		// prints 499.0
		System.out.println(st.getCategoryTotal("Loding")); 
		// prints 0.0
	}
}