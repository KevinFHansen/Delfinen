package subscription;

import members.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
        for seniorsvømmere (18 år og over) 1600 kr. årligt.
        For medlemmer over 60 år gives der 25 % rabat af seniortaksten.
        For passivt medlemskab er taksten 500 kr. årligt.*/

public class Subscription {

    private ArrayList<Member> memberSubscriptionList = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        Member et = new Member("Joachim",18,"djdjdjd",23232323,"Competitor","Male",false);
        Member to = new Member("Kevin",17,"djdjdjd",23232323,"Competitor","Male",true);
        Member tre = new Member("Michael",65,"djdjdjd",23232323,"Competitor","Male",true);
        Member fire = new Member("Jonas",20,"djdjdjd",23232323,"Competitor","Male",true);

        generateFee(et);
        generateFee(to);
        generateFee(tre);
        generateFee(fire);

        System.out.println(et.getsubscriptionFee());
        System.out.println(to.getsubscriptionFee());
        System.out.println(tre.getsubscriptionFee());
        System.out.println(fire.getsubscriptionFee());

        Subscription sub = new Subscription();

        sub.memberSubscriptionList.add(et);
        sub.writeSubscriptionToFile();

    }


    public static void generateFee(Member member){

        if (member.isMemberActive() == false){
            member.setSubscriptionFee(500.00);
        }
        else if (member.getAge() < 18 && member.isMemberActive()){
            member.setSubscriptionFee(1000.00);
        }
        else if (member.getAge() >= 18 && member.getAge() < 60 && member.isMemberActive()){
            member.setSubscriptionFee(1600.00);
        }
        else if (member.getAge() >= 60 && member.isMemberActive()){
            member.setSubscriptionFee(1200.00);
        }

    }

    public void writeSubscriptionToFile() throws IOException{

        File fout = new File("Delfin/Ressources/SubscriptionList.csv");

        FileWriter writer = new FileWriter(fout,true);

        for (int i = 0; i < memberSubscriptionList.size(); i++){
            writer.append(memberSubscriptionList.get(i).getName() + ";");
            writer.append(memberSubscriptionList.get(i).getPhoneNumber() + ";");
            writer.append(memberSubscriptionList.get(i).getsubscriptionFee() + "\n");
        }
        writer.close();
    }

}
