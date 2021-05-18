package members;

public class Member {
    private String name;
    private int age;
    private String email;
    private int phoneNumber;
    private double subscriptionFee;
    private String typeOfSubscription;
    private String gender;
    private boolean isMemberActive;


    public Member(String name, int age, String email, int phoneNumber, String typeOfSubscription, String gender, boolean isMemberActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.typeOfSubscription = typeOfSubscription;
        this.gender = gender;
        this.isMemberActive = isMemberActive;
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

    public double getsubscriptionFee() {
        return subscriptionFee;
    }

    public String getTypeOfSub() {
        return typeOfSubscription;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMemberActive() {
        return isMemberActive;
    }

    // setters


    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }
}
