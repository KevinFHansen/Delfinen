package subscription;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTestArrears {

    @Test
    void viewArrears() throws FileNotFoundException {
        //Arrange
        Payment payment = new Payment();

        //Act
        payment.viewArrears();

        //Assert


    }
}