package subscription;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void viewExpectedSubIncome() {
        //Arrange
        Payment pay = new Payment();

        //Act
        double sum = pay.getSum();

        //Assert
        Assertions.assertEquals(12600.0, sum);
    }
}