package members;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagement {

    //Indlæs MemberList metode
    //Søg me


    public static void main(String[] args) throws IOException {
        ArrayList<Member> readMemberList = menukort.indlæsMenukort();
        System.out.println(memberList);
        registerMember(memberList);
        System.out.println(memberList);
    }


    Member member = new Member(null, 0, null,0,0, null, null);
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

        //Den her skal nok ikke indgå
        System.out.println("Please type subscription price");
        double newMemberSubPrice = userInput.nextDouble();

        System.out.println("Please type what type of subscription the new member wants");
        String newMemberSubType = userInput.next();

        System.out.println("Please type gender");
        String newMemberGender = userInput.next();

        Member newMember = new Member(newMemberName, newMemberAge, newMemberEmail, newMemberPhoneNumber, newMemberSubPrice, newMemberSubType, newMemberGender);
        memberList.add(newMember);
        changeMemberList(memberList);
    }

    public static void updateMember(int phoneNumber){
    }

    public static void findMember(int phoneNumber){
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
            //Vi skal have styr på constructoren i member klassen.
            Member tmpMember = new Member(name, age, email, phoneNumber);
            memberList.add(tmpMember);
        }
        return readMemberList();
    }


    public static void removeMember(int phoneNumber) throws IOException {
        System.out.println("Please type phone number of the member you want to remove");
        phoneNumber = userInput.nextInt();
        for (int i = 0; i <= memberList.size(); i++) {
            Member memberToRemove = memberList.get(i);
            if(phoneNumber == memberToRemove.getPhoneNumber());
            memberList.remove(memberList.get(i));
            changeMemberList(memberList);
        }
        }


    public static void changeMemberList(ArrayList<Member> memberList) throws FileNotFoundException {
        File fout = new File("Delfin/Ressources/Members.csv");
        PrintWriter writer = new PrintWriter(fout);
        writer.print("");
        writer.println("name;age;email;phoneNumber");

        for (int i = 0; i < memberList.size(); i++){
            writer.print(memberList.get(i).getName() + ";");
            writer.print(memberList.get(i).getAge() + ";");
            writer.print(memberList.get(i).getEmail() + ";");
            writer.println(memberList.get(i).getPhoneNumber() + ";");
        }
        writer.close();
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberlist(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

}
