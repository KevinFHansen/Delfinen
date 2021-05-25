package subscription;

import members.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    private int period;
    private double totalPrice;
    private int memberPhoneNumber;
    private double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
    Payment n = new Payment();
    n.viewExpectedSubIncome();
    n.viewArrears();
    }


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


    public double viewExpectedSubIncome() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/SubscriptionList.csv");
        Scanner readCsv = new Scanner(f);
        ArrayList<Double> arraySubIncome = new ArrayList<>();
        Member member = new Member(null, 0, null, 0, null, null, true, true);
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
                for(int i = 0; i < arraySubIncome.size(); i++){
                    sum1 = sum - arraySubIncome.get(i);
                }
                //sum1 = (sum - member.getsubscriptionFee());
            }

        }
        System.out.println("This is the expected sub Income: " + sum);
        System.out.println("This is the actual sub income: " + sum1);
        setSum(sum);
        return sum;
    }
}