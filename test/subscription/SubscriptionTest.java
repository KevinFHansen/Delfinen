package subscription;

// @author Lars Brogaard Kaiser

import members.Member;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class SubscriptionTest {

    /*For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
        for seniorsvømmere (18 år og over) 1600 kr. årligt.
        For medlemmer over 60 år gives der 25 % rabat af seniortaksten.
        For passivt medlemskab er taksten 500 kr. årligt.*/

    @Test
    void generateFee() {

        // Arrange
        Subscription subscription = new Subscription();
        Member under18 = new Member("Lars",17,"dldld",30303030,"Exercise","Male",true, true);
        Member senior = new Member("Ole",32,"dldld",30303030,"Exercise","Male",true, true);
        Member passive = new Member("Kevin",40,"dldld",30303030,"Exercise","Male",false, true);
        Member discount = new Member("Joachim",61,"dldld",30303030,"Exercise","Male",true, true);

        Subscription.memberSubscriptionList.add(under18);
        Subscription.memberSubscriptionList.add(senior);
        Subscription.memberSubscriptionList.add(passive);
        Subscription.memberSubscriptionList.add(discount);

        subscription.generateFee(Subscription.memberSubscriptionList);

        // Act
        double fee1 = under18.getsubscriptionFee();
        double fee2 = senior.getsubscriptionFee();
        double fee3 = passive.getsubscriptionFee();
        double fee4 = discount.getsubscriptionFee();

        // Assert
        assertEquals(1000,fee1);
        assertEquals(1600,fee2);
        assertEquals(500,fee3);
        assertEquals(1200,fee4);

    }
}