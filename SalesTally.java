import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class SalesTally {
    private ArrayList<Sale> a;
    
    public SalesTally(String salesFileName) {
        a = new ArrayList<Sale>();
        String line;
        String[] gap;
        try(Scanner inFile = new Scanner(new File(salesFileName))) {
            while(inFile.hasNextLine()) {
                line = inFile.nextLine();
                gap = line.split(";");
                a.add(new Sale(gap[0], gap[1], Double.parseDouble(gap[2]), gap[3]));
            }           
            inFile.close();    
        } catch(FileNotFoundException e) {
		    System.out.println("File: " + salesFileName + " not found");
		}
    }  
    
    public double getCategoryTotal(String category) {
        double z = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i).getServiceCategory().equalsIgnoreCase(category)) {
                z = z + a.get(i).getAmount();
            } 
        }
        return z;
    }
}