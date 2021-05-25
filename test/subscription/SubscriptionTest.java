package subscription;

import members.Member;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @Test
    void generateFee() {

        // Arrange
        Subscription subscription = new Subscription();
        Member member = new Member("Lars",17,"dldld",30303030,"Exercise","Male",true, true);


        // Act
        double fee =


        // Assert
        assertEquals(1000,fee);

    }
}