package subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Payment {
    private int period;
    private double totalPrice;
    private int memberPhoneNumber;

    public void viewArrears() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        
    }
}
