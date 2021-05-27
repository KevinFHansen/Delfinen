package subscription;
// @author Michael Dyvad
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ViewSubIncomeTest {

    @org.junit.jupiter.api.Test
    void viewExpectedSubIncome() throws FileNotFoundException {
        //Arrange
        Payment pay = new Payment();

        //Act
        pay.viewExpectedSubIncome();
        double expectedSubIncome = pay.getSum();

        //You have to write in the expected subscription income manually when changes occurs.
        //Assert
        Assertions.assertEquals(180400.0, expectedSubIncome);

    }
}