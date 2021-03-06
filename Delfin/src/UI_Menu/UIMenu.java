package UI_Menu;

// @author Kevin Funch Hansen

import compettition.TeamManagement;
import members.Member;
import members.MemberManagement;
import subscription.Payment;
import subscription.Subscription;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    TeamManagement teamManagement = new TeamManagement();
    Subscription subscription = new Subscription();
    Payment payment = new Payment();
    MemberManagement memberManagement = new MemberManagement();
    Scanner scn = new Scanner(System.in);


    public void startUI() throws IOException {
        ArrayList<Member> memberList = memberManagement.readMemberList();

        boolean exitProgram = false;

        while (!exitProgram){

            mainMenu();

            int userInput = scn.nextInt();

            switch (userInput){

                case 1:
                    memberManagementMenu();

                    int choice = scn.nextInt();
                    if (choice == 1){
                        memberManagement.registerMember(memberList);
                        ArrayList<Member> memberListToUpdate =  memberList;

                        subscription.generateFee(memberListToUpdate);

                        ArrayList<Member> memberSubscriptionList = subscription.addMembersToSub(memberListToUpdate);

                        subscription.createSubscriptionlist(memberSubscriptionList);
                        //subscription.generateFee(memberList);
                        //subscription.createSubscriptionlist(memberList);
                        //subscription.addMembersToSub(memberList);

                    }
                else if(choice == 2){
                        memberManagement.updateMember(memberList);

                        ArrayList<Member> memberListToUpdate = new ArrayList<Member>();

                        memberListToUpdate = memberList;

                        subscription.generateFee(memberListToUpdate);

                        ArrayList<Member> memberSubscriptionList = subscription.addMembersToSub(memberListToUpdate);

                        subscription.createSubscriptionlist(memberSubscriptionList);

                    }
                else if (choice == 3){
                        memberManagement.removeMember(memberList);

                        ArrayList<Member> memberListToUpdate = new ArrayList<Member>();

                        memberListToUpdate = memberList;

                        subscription.generateFee(memberListToUpdate);

                        ArrayList<Member> memberSubscriptionList = subscription.addMembersToSub(memberListToUpdate);

                        subscription.createSubscriptionlist(memberSubscriptionList);

                    }
                else if (choice == 4){
                        memberManagement.viewMember(memberList);

                    }
                else if (choice == 5){
                        System.out.println("Back");

                    }
                else {
                        System.out.println("Wrong Input - Try again");
                    }
                    break;

                case 2:

                    teamManagement.runTeamManagement();

                    break;

                case 3:

                    subManagementMenu();

                    int choice3 = scn.nextInt();
                    if (choice3 == 1){
                        payment.viewArrears();

                    }
                else if (choice3 == 2){
                        System.out.println("Expected subscription income: ");
                        payment.viewExpectedSubIncome();

                    }
                else if (choice3 == 0){

                    }
                else {
                        System.out.println("Wrong input");

                    }
                    break;


                case 0:
                    System.out.println("You choose to exit");
                    exitProgram = true;

            }
        }
    }

    //Menu's

    public void mainMenu(){
        System.out.println("1. Member Management");
        System.out.println("2. Team Management");
        System.out.println("3. Subscription Management");
        System.out.println("0. Exit Program");
}
    public void memberManagementMenu(){
        System.out.println("Member Management");
        System.out.println("1. Register Member");
        System.out.println("2. Update Member");
        System.out.println("3. Remove Member");
        System.out.println("4. View Member");
        System.out.println("5. Back");
    }

    public void subManagementMenu(){
        System.out.println("1. View Arrears");
        System.out.println("2. View Expected sub income");
        System.out.println("0. Exit");
    }
}

