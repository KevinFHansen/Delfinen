package subscription;

public class Payment {
    private int period;
    private boolean isPaid;
    private double totalPrice;
    private int memberPhoneNumber;

    public Payment(int period, boolean isPaid, double totalPrice, int memberPhoneNumber){
        this.period = period;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
        this.memberPhoneNumber = memberPhoneNumber;
    }

}
