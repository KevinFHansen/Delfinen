package subscription;

// @author Lars Brogaard Kaiser

import members.Member;

import java.io.*;
import java.util.ArrayList;


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

    // Adding instance of Member class to the attribute memberSubscriptionList
    public ArrayList<Member> addMembersToSub(ArrayList<Member> members){
        for (int i = 0; i < members.size(); i ++){
            memberSubscriptionList.add(members.get(i));
        }
        return memberSubscriptionList;
    }

    // writing list of subscriptions to csv-file
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

}