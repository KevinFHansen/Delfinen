package UI_Menu;

import members.Member;
import members.MemberManagement;
import subscription.Payment;
import subscription.Subscription;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    Member member = new Member(null, 0, null,0,null, null, true, true);
    Subscription subscription = new Subscription();
    Payment payment = new Payment();
    MemberManagement memberManagement = new MemberManagement();
    Scanner scn = new Scanner(System.in);





    public void startUI() throws FileNotFoundException {
        ArrayList<Member> memberList = memberManagement.readMemberList();

        boolean exitProgram = false;

        while (exitProgram){

        int userInput = scn.nextInt();

        switch (userInput){

            case 1:
                System.out.println("Member Management");
                System.out.println("1. Register member");
                System.out.println("2. Update member");
                System.out.println("3. Remove member");
                System.out.println("4. Find member");

                int choice = scn.nextInt();
                if (choice == 1){
                    memberManagement.registerMember(memberList);
                }
                break;

            case 2:
                System.out.println("Results Management");
                break;

            case 3:
                System.out.println("View subscriptions");
        }

        }

    }

}
