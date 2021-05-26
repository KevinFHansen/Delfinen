package subscription;
// @author Michael Dyvad
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;

class PaymentTest {

    //The purpose of the test is to figure out if the sum has the right expected subscription income.
    @Test
    void viewExpectedSubIncome() throws FileNotFoundException {
        //Arrange
        Payment pay = new Payment();

        //Act
        pay.viewExpectedSubIncome();
        double expectedSubIncome = pay.getSum();

        //You have to write in the expected subscription income manually when changes occurs.
        //Assert
        Assertions.assertEquals(8000.0, expectedSubIncome);
    }
}