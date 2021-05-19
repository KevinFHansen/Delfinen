package subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    private int period;
    private double totalPrice;
    private int memberPhoneNumber;


    public static void main(String[] args) throws FileNotFoundException {
    Payment n = new Payment();
    n.viewExpectedSubIncome();
    }

    public void viewArrears() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        
    }
    public void viewExpectedSubIncome() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        ArrayList<Double> n = new ArrayList<>();
        double sum = 0;
        while(readCsv.hasNextLine()){

            String currentLine = readCsv.nextLine();

            String[] csvAsArray = currentLine.split(";");


            double subIncome = Double.parseDouble(csvAsArray[2]);


            n.add(subIncome);
            sum = sum + subIncome;

        }
        System.out.println("This is the expected sub Income: " + sum);

    }
}
