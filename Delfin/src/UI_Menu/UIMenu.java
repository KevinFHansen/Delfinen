package UI_Menu;

// @author Kevin Funch Hansen

import members.Member;
import members.MemberManagement;
import subscription.Payment;
import subscription.Subscription;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    Member member = new Member(null, 0, null,0,null, null, true, true);
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
                    subscription.generateFee(memberList);
                    subscription.createSubscriptionlist(memberList);
                    subscription.addMembersToSub(memberList);

                }
                else if(choice == 2){
                    memberManagement.updateMember(memberList);

                }
                else if (choice == 3){
                    memberManagement.removeMember(memberList);

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

                resultManagementMenu();

                int choice1 = scn.nextInt();

                if (choice1 == 1) {

                    trainingResultMenu();

                    int choice2 = scn.nextInt();
                    if (choice2 == 1){
                        //registerTrainingResult();
                    }
                    else if (choice2 == 2){
                        //updateTrainingResult();
                    }
                    else if (choice2 == 3){
                        //deleteTrainingResult();
                    }
                    else if(choice2 == 4){
                        //Go back
                    }
                    else{
                        System.out.println("Wrong input - Try again");
                    }
                }
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
        System.out.println("2. Result Management");
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

    public void resultManagementMenu(){
        System.out.println("Result Management");
        System.out.println("1. Training Results");
        System.out.println("2. Competitive Results");
        System.out.println("3. Back");
    }

    public void trainingResultMenu(){
        System.out.println("Training Results");
        System.out.println("1. Register Result");
        System.out.println("2. Update Result");
        System.out.println("3. Delete Result");
        System.out.println("4. Back");
    }

    public void subManagementMenu(){
        System.out.println("1. View Arrears");
        System.out.println("2. View Expected sub income");
        System.out.println("0. Exit");
    }
}

