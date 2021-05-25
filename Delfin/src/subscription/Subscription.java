package subscription;

// @author Lars Brogaard Kaiser
// Gruppe 6

import members.Member;

import java.io.*;
import java.util.ArrayList;

/*For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
        for seniorsvømmere (18 år og over) 1600 kr. årligt.
        For medlemmer over 60 år gives der 25 % rabat af seniortaksten.
        For passivt medlemskab er taksten 500 kr. årligt.*/

public class Subscription {

    static ArrayList<Member> memberSubscriptionList = new ArrayList<>();

    // sets the attribute SubscriptionFee in Member class
    public void generateFee(ArrayList<Member> members){

        for (int i = 0; i < members.size(); i ++) {

            if (members.get(i).isMemberActive() == false) {
                members.get(i).setSubscriptionFee(500.00);
            } else if (members.get(i).getAge() < 18 && members.get(i).isMemberActive()) {
                members.get(i).setSubscriptionFee(1000.00);
            } else if (members.get(i).getAge() >= 18 && members.get(i).getAge() < 60 && members.get(i).isMemberActive()) {
                members.get(i).setSubscriptionFee(1600.00);
            } else if (members.get(i).getAge() >= 60 && members.get(i).isMemberActive()) {
                members.get(i).setSubscriptionFee(1200.00);
            }
        }
    }

    public void addMembersToSub(ArrayList<Member> members){
        for (int i = 0; i < members.size(); i ++){
            memberSubscriptionList.add(members.get(i));
        }
    }


    public void createSubscriptionlist(ArrayList<Member> memberSubscriptionList) throws FileNotFoundException{

        File fout = new File("Delfin/Ressources/SubscriptionList.csv");
        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("Name;PhoneNumber;SubscriptionFee;HasPaid");

        for(int i = 0; i < memberSubscriptionList.size(); i++){
            writer.print(memberSubscriptionList.get(i).getName() + ";");
            writer.print(memberSubscriptionList.get(i).getPhoneNumber() + ";");
            writer.print(memberSubscriptionList.get(i).getSubscriptionFee() + ";");
            writer.println(memberSubscriptionList.get(i).getHasPaid());
        }
        writer.close();

    }

    public void writeSubscriptionToFile(ArrayList<Member> members) throws IOException{

        File fout = new File("Delfin/Ressources/SubscriptionList.csv");
        FileWriter writer = new FileWriter(fout,true);


        for (int i = 0; i < memberSubscriptionList.size(); i++){
            writer.append(memberSubscriptionList.get(i).getName() + ";");
            writer.append(memberSubscriptionList.get(i).getPhoneNumber() + ";");
            writer.append(memberSubscriptionList.get(i).getsubscriptionFee() + ";");
            writer.append(memberSubscriptionList.get(i).getHasPaid() + ("\n"));
        }
        writer.close();
    }
}