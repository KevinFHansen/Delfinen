package members;

public class Member {
    private String name;
    private int age;
    private String email;
    private int phoneNumber;
    private double subscriptionPrice;
    private String typeOfSub;
    private String gender;
    private boolean isMembershipActive;
    private boolean isMemberSenior;
    private boolean is60Plus;

    public Member(String name, int age, String email, int phoneNumber, double subscriptionPrice, String typeOfSub, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subscriptionPrice = subscriptionPrice;
        this.typeOfSub = typeOfSub;
        this.gender = gender;
    }

    //getters
    //hello
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public String getTypeOfSub() {
        return typeOfSub;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMembershipActive() {
        return isMembershipActive;
    }

    public boolean isMemberSenior() {
        return isMemberSenior;
    }

    public boolean isIs60Plus() {
        return is60Plus;
    }

}
