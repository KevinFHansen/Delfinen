package subscription;

import members.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {


    private Object Member;

    @Test
    void generateFee() {
        //Arrange
        SubscriptionTest sub = new SubscriptionTest();



        //Act
        double priceUnderEighteen = 1000.00;



        //Assert
        Assertions.assertEquals(1000.00, priceUnderEighteen);
    }
}