package subscription;

import members.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Payment {
    private double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    //The viewArrears method can show the members who haven´t paid their subscription
    public void viewArrears() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        System.out.println("Members who arrears: ");
        readCsv.nextLine();
        while(readCsv.hasNextLine()){

            String currentLine = readCsv.nextLine();

            String[] csvAsArray = currentLine.split(";");

            String name = csvAsArray[0];
            double subIncome = Double.parseDouble(csvAsArray[2]);
            boolean whoArrears = Boolean.parseBoolean(csvAsArray[3]);

            if(whoArrears == false){
                System.out.println(name + ": Remain to pay: " + subIncome);
            }
        }
    }

    //The viewExpectedSubIncome method calculate the expected subscription income and the actual subscription income
    public void viewExpectedSubIncome() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        ArrayList<Double> arraySubIncome = new ArrayList<>();
        double sum1 = 0;
        double sum2 = 0;

        readCsv.nextLine();
        while(readCsv.hasNextLine()){

            String currentLine = readCsv.nextLine();

            String[] csvAsArray = currentLine.split(";");

            boolean whoArrears = Boolean.parseBoolean(csvAsArray[3]);
            double subIncome = Double.parseDouble(csvAsArray[2]);


            arraySubIncome.add(subIncome);
            sum = sum + subIncome;


            if(whoArrears == false){
                sum1 = sum1 + subIncome;
            }
            sum2 = sum - sum1;

        }
        System.out.println("This is the subscription income from the period 01/01/2021 - 01/12/2021");
        System.out.println("This is the expected sub Income: " + sum);
        System.out.println("This is the actual sub income: " + sum2);

        setSum(sum);
    }
}