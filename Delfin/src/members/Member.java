package members;

public class Member {
    private String name;
    private int age;
    private String email;
    private int phoneNumber;
    private double subscriptionFee;
    private String typeOfSubcription;
    private String gender;
    private boolean isMemberActive;


    public Member(String name, int age, String email, int phoneNumber, double subscriptionPrice, String typeOfSub, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subscriptionPrice = subscriptionPrice;
        this.typeOfSub = typeOfSub;
        this.gender = gender;
    }

    //getters123

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


}
