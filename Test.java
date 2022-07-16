import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Test {
	@Test
	void testaverageColumns() {
		boolean success = false;
		Main.problem1_averageColumns("columns.txt", "averages.txt");
		try (Scanner inputReader = new Scanner(new File("averages.txt"))) {
			assertEquals(34.75333333333333, inputReader.nextDouble(), 1e-14);
			assertEquals(59.400000000000006, inputReader.nextDouble(), 1e-14);
			success = true;
		} catch (FileNotFoundException exception) {
			fail("File: averages.txt not found");
		}
		if (success) {
			cleanUp("averages.txt");
		}
	}

	@Test
	void testSpellChecker() {
		SpellChecker checker = new SpellChecker("words.txt");
		ArrayList<String> notFoundWords = checker.checkFile("doc.txt"), result = new ArrayList<>(Arrays.asList(
				new String[] { "foolishness", "incredulity", "Charles", "A", "I", "havent", "Christmas", "Oliver" }));
		Collections.sort(notFoundWords);
		Collections.sort(result);
		assertTrue(notFoundWords.equals(result));
	}

	@Test
	void testAirportData() {
		AirportData ad = new AirportData("airports.dat");
		ArrayList<String> airports = ad.getAllAirportsInCity("Seoul");
		Collections.sort(airports);
		assertTrue(airports.equals(new ArrayList<>(
				Arrays.asList(new String[] { "Gimpo International Airport", "Incheon International Airport" }))));
		airports = ad.getAllAirportsInCity("Irvine");
		assertTrue(airports.size() == 0);
	}

	@Test
	void testBank() {
		Bank bank = new Bank();
		bank.readFile("accounts1.dat");
		BankAccount highest = bank.getHighestBalanceAccount();
		assertEquals(9, highest.getAccountNumber());
		assertEquals(34897.0, highest.getBalance(), 1e-14);
		bank.readFile("accounts2.dat");
		highest = bank.getHighestBalanceAccount();
		assertEquals(5, highest.getAccountNumber());
		assertEquals(35000.98, highest.getBalance(), 1e-14);
	}

	@Test
	void testSalesTally() {
		SalesTally st = new SalesTally("sales.txt");
		assertEquals(53.4, st.getCategoryTotal("Dinner"), 1e-14);
		assertEquals(499.0, st.getCategoryTotal("Conference"), 1e-14);
		assertEquals(0.0, st.getCategoryTotal("Loding"), 1e-14);
	}

	@Test
	void testAirplane() {
		Airplane plane = new Airplane();
		assertTrue(plane.addPassengers(Airplane.FIRST, 2, SeatRow.AISLE));
		assertTrue(plane.addPassengers(Airplane.FIRST, 1, SeatRow.WINDOW));
		assertTrue(plane.addPassengers(Airplane.ECONOMY, 3, SeatRow.AISLE));
		assertTrue(plane.addPassengers(Airplane.ECONOMY, 2, SeatRow.WINDOW));
	}

	void cleanUp(String fileName) {
		try {
			if (new File(fileName).delete() == false) {
				System.out.printf("File: %s not deleted%n", fileName);
			}
		} catch (SecurityException exception) {
			System.out.printf("File: %s not deleted due to permission issues%n", fileName);
		}
	}
}