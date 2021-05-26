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
    private boolean hasPaid;


    public Member(String name, int age, String email, int phoneNumber, String typeOfSubscription, String gender, boolean isMemberActive, boolean hasPaid) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.typeOfSubscription = typeOfSubscription;
        this.gender = gender;
        this.isMemberActive = isMemberActive;
        this.hasPaid = hasPaid;
    }

    public Member(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //getters

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

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public String getTypeOfSubscription() {
        return typeOfSubscription;
    }

    public boolean getIsMemberActive(){
        return isMemberActive;
    }


    public boolean getHasPaid() {
        return hasPaid;
    }

    // setters

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTypeOfSubscription(String typeOfSubscription) {
        this.typeOfSubscription = typeOfSubscription;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMemberActive(boolean memberActive) {
        isMemberActive = memberActive;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    @Override
    public String   toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", subscriptionFee=" + subscriptionFee +
                ", typeOfSubscription='" + typeOfSubscription + '\'' +
                ", gender='" + gender + '\'' +
                ", isMemberActive=" + isMemberActive +
                ", hasPaid=" + hasPaid +
                '}';
    }
}
