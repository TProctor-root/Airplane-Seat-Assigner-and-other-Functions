import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Bank {
    private double a;
    private double b;
    
    public Bank() {
        a = 0;
        b = 0;
    }  
    
    public void readFile(String fileName) {
    	String line;
    	String[] gap;
        try(Scanner inFile = new Scanner(new File(fileName))) {
            while(inFile.hasNext()) {
                line = inFile.nextLine();
                gap = line.split("\\s+");
                if(b < Double.parseDouble(gap[1])){
                    b = Double.parseDouble(gap[1]);
                    a = Double.parseDouble(gap[0]);
                }
            }
            inFile.close();
        } catch(FileNotFoundException e) {
		    System.out.println("File: " + fileName + " not found");
		}
        
    } 
    
    public BankAccount getHighestBalanceAccount() {
        int z = (int)a;
        return new BankAccount(z, b);
    } 
}