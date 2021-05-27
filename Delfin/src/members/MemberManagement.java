package members;

// @author Kevin Funch Hansen

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
public class MemberManagement {

    Member member = new Member(null, 0, null,0,null, null, true, true);
    //ArrayList<Member> memberList = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);

    // Registers an instance of a member and safes it in an Arraylist
    public static void registerMember(ArrayList<Member> memberList) throws FileNotFoundException {

        System.out.println("Register new member");
        System.out.println("Please type name: ");
        String newMemberName = userInput.next();

        System.out.println("Please type age: ");
        int newMemberAge = userInput.nextInt();

        System.out.println("Please type Email: ");
        String newMemberEmail = userInput.next();

        System.out.println("Please type phone number: ");
        int newMemberPhoneNumber = userInput.nextInt();

        System.out.println("Please type type of subscription");
        String newMemberSubType = userInput.next();

        System.out.println("Please type gender");
        String newMemberGender = userInput.next();

        System.out.println("Please type if member is active (true/false)");
        boolean isNewMemberActive = userInput.nextBoolean();

        System.out.println("Please type if members has paid (true/false)");
        boolean hasNewMemberPaid = userInput.nextBoolean();

        Member newMember = new Member(newMemberName, newMemberAge, newMemberEmail, newMemberPhoneNumber, newMemberSubType, newMemberGender, isNewMemberActive, hasNewMemberPaid);
        memberList.add(newMember);
        createMemberList(memberList);
    }

    // View registered members - Update directly

    public static void viewMember(ArrayList<Member> memberList) throws FileNotFoundException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Memberlist:");
        for (int i = 0; i < memberList.size(); i++){
            System.out.println(memberList.get(i));
        }


        System.out.println("Do you want to update a member?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = scn.nextInt();
            if (choice == 1) {
                updateMember(memberList);
            }

            else {

            }
    }


    //Updates registered members - Prompts for registered phone number
    public static void updateMember(ArrayList<Member> memberList) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please type phone number of the member u want to update");

        try {

        int phoneNumber = sc.nextInt();


            for (int i = 0; i < memberList.size(); i++) {

                Member memberToUpdate = memberList.get(i);

                if (Objects.equals(memberList.get(i).getPhoneNumber(), phoneNumber)) {

                    updateMemberMenu();

                    int choice = 10;
                    while (choice != 0) {

                        choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {

                            case 1:
                                System.out.println("Update name");
                                memberToUpdate.setName(sc.next());
                                choice = 0;
                                break;

                            case 2:
                                System.out.println("Update age");
                                memberToUpdate.setAge(sc.nextInt());
                                choice = 0;
                                break;

                            case 3:
                                System.out.println("Update email");
                                memberToUpdate.setEmail(sc.next());
                                choice = 0;
                                break;

                            case 4:
                                System.out.println("Update phone number");
                                memberToUpdate.setPhoneNumber(sc.nextInt());
                                choice = 0;
                                break;

                            case 5:
                                System.out.println("Update type of subscription");
                                memberToUpdate.setTypeOfSubscription(sc.next());
                                choice = 0;
                                break;

                            case 6:
                                System.out.println("Update gender");
                                memberToUpdate.setGender(sc.next());
                                choice = 0;
                                break;

                            case 7:
                                System.out.println("Update if member is active or not");
                                memberToUpdate.setMemberActive(sc.nextBoolean());
                                choice = 0;
                                break;

                            case 8:
                                System.out.println("Update payment status");
                                memberToUpdate.setHasPaid(sc.nextBoolean());
                                choice = 0;
                                break;

                            case 0:
                                break;

                        }
                    }
                    createMemberList(memberList);
                }
            }
        }

        catch (InputMismatchException e) {
            System.out.println("Wrong input - try again");
        }
    }

    //Reads the csv file members - Defines how to read it. Creates the files as an array

    public ArrayList<Member> readMemberList() throws FileNotFoundException {
        File membersList = new File("Delfin/Ressources/Members.csv");
        Scanner readFileScanner = new Scanner(membersList);
        ArrayList<Member> memberList = new ArrayList<>();

        readFileScanner.nextLine();

        while (readFileScanner.hasNext()){
            String thisLine = readFileScanner.nextLine();

            String[] lineAsAray = thisLine.split(";");

            String name = lineAsAray[0].trim();
            int age = Integer.parseInt(lineAsAray[1].trim());
            String email = lineAsAray[2].trim();
            int phoneNumber = Integer.parseInt(lineAsAray[3].trim());
            String subType = lineAsAray[4].trim();
            String gender = lineAsAray[5].trim();
            boolean isMemberActive = Boolean.parseBoolean(lineAsAray[6].trim());
            boolean hasMemberPaid = Boolean.parseBoolean(lineAsAray[7].trim());
            Member tmpMember = new Member(name, age, email, phoneNumber, subType, gender, isMemberActive, hasMemberPaid);
            memberList.add(tmpMember);
        }
        System.out.println(memberList.size());

        return memberList;

    }

    //Method to members - Can't delete if member has arrears
    public static void removeMember(ArrayList<Member> memberList) throws IOException {

        System.out.println("Please type phone number of the member you want to remove");

        int phoneNumber = userInput.nextInt();
        for (int i = 0; i < memberList.size(); i++) {

            if (Objects.equals(memberList.get(i).getPhoneNumber(), phoneNumber) && memberList.get(i).getHasPaid() == false) {
                System.out.println("Can't delete member - Has arrears");
                break;
            }
             else if (Objects.equals(memberList.get(i).getPhoneNumber(), phoneNumber)) {
                System.out.println("You have delelted: " + i);
                memberList.remove(i);
                break;
            }
        }
        createMemberList(memberList);
    }
    // writing list of members to csv-file

    public static void createMemberList(ArrayList<Member> memberList) throws FileNotFoundException {
        File fout = new File("Delfin/Ressources/Members.csv");
        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("name;age;email;phoneNumber;subscriptionType;gender;isMemberActive;hasMemberPaid");

        for (int i = 0; i < memberList.size(); i++){
            writer.print(memberList.get(i).getName() + ";");
            writer.print(memberList.get(i).getAge() + ";");
            writer.print(memberList.get(i).getEmail() + ";");
            writer.print(memberList.get(i).getPhoneNumber() + ";");
            writer.print(memberList.get(i).getTypeOfSubscription() + ";");
            writer.print(memberList.get(i).getGender() + ";");
            writer.print(memberList.get(i).getIsMemberActive() + ";");
            writer.println(memberList.get(i).getHasPaid() + ";");
        }
        writer.close();
    }


    //Update menu

    public static void updateMemberMenu(){
        System.out.println("What would u like to update?");
        System.out.println("1. Update name");
        System.out.println("2. Update age");
        System.out.println("3. Update email");
        System.out.println("4. Update phone number");
        System.out.println("5. Update type of subscription");
        System.out.println("6. Update Gender");
        System.out.println("7. Update if member is active");
        System.out.println("8. Update if member has paid subscription");
        System.out.println("0. Exit");
    }

}
