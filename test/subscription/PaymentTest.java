package subscription;

import members.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void viewExpectedSubIncome() throws FileNotFoundException {
        //Arrange
        Payment pay = new Payment();

        //Act
        pay.viewExpectedSubIncome();
        double sum = pay.getSum();

        //Assert
        Assertions.assertEquals(5900.0, sum);
    }
}