package members;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagement {

    Member member = new Member(null, 0, null,0,null, null, true, true);
    private static ArrayList<Member> memberList = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);

    //Skal kunne oprette et nyt medlem og registrere data - Gemme members i en arraylist
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


    //Den her metode fungere ikke helt optimalt, ville være smartere hvis man kunne nøjes med at ændre atributter

    /*public static void updateMember1(int phoneNumber) throws FileNotFoundException {
        System.out.println("Please type the phone number of the member you want to update");
        phoneNumber = userInput.nextInt();
        userInput.nextLine();


        System.out.println("Please type name: ");
        String updateMemberName = userInput.next();

        System.out.println("Please type age: ");
        int updateMemberAge = userInput.nextInt();

        System.out.println("Please type Email: ");
        String updateNewMemberEmail = userInput.next();

        System.out.println("Please type phone number: ");
        int updatePhoneNumber = userInput.nextInt();

        //
        System.out.println("Please type type of subscription");
        String updateMemberSubType = userInput.next();

        System.out.println("Please type gender: ");
        String updateMemberGender =  userInput.next();

        System.out.println("Please type if member is active (true/false)");
        boolean updateIsMemberActive = userInput.nextBoolean();

        System.out.println("Please type if the member has paid (true/false)");
        boolean updateHasMemberPaid = userInput.nextBoolean();

        Member updateMember = new Member(updateMemberName, updateMemberAge, updateNewMemberEmail, updatePhoneNumber, updateMemberSubType, updateMemberGender, updateIsMemberActive, updateHasMemberPaid);
        memberList.add(updateMember);
        createMemberList(memberList);


    }*/

    public static void viewMember(ArrayList<Member> memberList){
        System.out.println("Memberlist");
        for (int i = 0; i < memberList.size(); i++){
            System.out.println(memberList.get(i));
        }
    }



    public static void updateMember() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type phone number of the member u want to update");
        int phoneNumber = sc.nextInt();
            Member memberToUpdate = memberList.get(phoneNumber);
            System.out.println(memberToUpdate);
            if (phoneNumber == memberToUpdate.getPhoneNumber());

            updateMemberMenu();

            int choice = 10;
            while (choice != 0) {

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Update name");
                        memberToUpdate.setName(sc.next());
                        break;

                    case 2:
                        System.out.println("Update age");
                        memberToUpdate.setAge(sc.nextInt());
                        break;

                    case 3:
                        System.out.println("Update email");
                        memberToUpdate.setEmail(sc.next());
                        break;

                    case 4:
                        System.out.println("Update phone number");
                        memberToUpdate.setPhoneNumber(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Update type of subscription");
                        memberToUpdate.setTypeOfSubscription(sc.next());
                        break;

                    case 6:
                        System.out.println("Update gender");
                        memberToUpdate.setGender(sc.next());
                        break;

                    case 7:
                        System.out.println("Update if member is active or not");
                        memberToUpdate.setMemberActive(sc.nextBoolean());
                        break;

                    case 8:
                        System.out.println("Update payment status");
                        memberToUpdate.setHasPaid(sc.nextBoolean());
                        break;

                    case 0:
                        break;

                }
                createMemberList(memberList);
                choice = 0;
            }


    }

    public ArrayList<Member> readMemberList() throws FileNotFoundException {
        File membersList = new File("Delfin/Ressources/Members.csv");
        Scanner readFileScanner = new Scanner(membersList);

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
        return memberList;
    }

    public static void removeMember(ArrayList<Member> memberList) throws IOException {
        System.out.println("Please type phone number of the member you want to remove");
        int phoneNumber = userInput.nextInt();
        for (int i = 0; i <= memberList.size(); i++) {
            Member memberToRemove = memberList.get(i);
            if(phoneNumber == memberToRemove.getPhoneNumber());
            //memberList.remove(memberList.get(i));
            memberList.remove(memberToRemove);

            createMemberList(memberList);
        }
    }

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
          //  writer.print(i + 1 + ";");
            writer.println(memberList.get(i).getHasPaid() + ";");
        }
        writer.close();
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberlist(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }


    public static void main(String[] args) throws IOException {
        Member member = new Member(null, 0, null,0,null, null, true, true);
        MemberManagement memberManagement = new MemberManagement();
        ArrayList<Member> memberList = memberManagement.readMemberList();
        //findMember(memberList);
        /*updateMember();
        registerMember(memberList);
        removeMember(memberList);*/

    }

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
