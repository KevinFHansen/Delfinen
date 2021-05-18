package members;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagement {
    public static void main(String[] args) {
        registerMember();
    }

    //Member member = new Member(null, 0, null,0,null, null, );
    private ArrayList<Member> memberlist = new ArrayList<>();

    public ArrayList<Member> getMemberlist() {
        return memberlist;
    }

    public void setMemberlist(ArrayList<Member> memberlist) {
        this.memberlist = memberlist;
    }

    //String name, int age, String email, int phoneNumber, String address, String gender, double subscriptionPrice
    //Skal kunne oprette et nyt medlem og registrere data - Gemme members i en arraylist
    public static void registerMember(){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please type Name, Age, Email, phone number, address, gender, and subPrice");
        //Member newMember = new Member(userInput.next(), userInput.nextInt(), userInput.next(), userInput.nextInt(), userInput.next(), userInput.next(), userInput.nextDouble());
        //System.out.println(newMember);

    }

    public static void updateMember(){
    }

    public static void findMember(){
    }

    public static void removeMember(){
    }

}
