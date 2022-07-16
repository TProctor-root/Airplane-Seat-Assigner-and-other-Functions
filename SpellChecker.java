import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker {
	private Set<String> z;
	
	SpellChecker(String wordListFileName) {
		z = new HashSet<String>();
		try(Scanner inFile = new Scanner(new File(wordListFileName))) {
			while(inFile.hasNext()) {
				z.add(inFile.next().toLowerCase());
			}
			inFile.close();
		} catch(FileNotFoundException e) {
			System.out.println("File: " + wordListFileName + " not found");
		}
	}
	
	boolean checkWord(String word) {
		word = word.toLowerCase();
		word = word.replaceAll("[^a-z]","");
		word = word.trim();
		if(word.equals("")) {
			return true;
		}
		return z.contains(word);
	}
	
	ArrayList<String> checkFile(String fileName) {
		String a;
		String b;
		ArrayList<String> x = new ArrayList<String>();
		try(Scanner inFile = new Scanner(new File(fileName))) {
			while(inFile.hasNext()) {
				a = inFile.next();
				a = a.replaceAll("[^A-Za-z]+","");
				b = a.toLowerCase();
				b = a.trim();
				if(!x.contains(b) && !checkWord(b)) {
					x.add(a);
				}
			}
			inFile.close();
		} catch(FileNotFoundException e) {
			System.out.println("File: " + fileName + " not found");
		}
		return x;
	}
}