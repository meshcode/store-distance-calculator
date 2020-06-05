package Steps;

import com.kujawski.Calculate;
import com.kujawski.Point;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    double distance = 0;

    @Given("Calculator module and Point module is OK")
    public void calculatorModuleAndPointModuleIsOK() {
    }

    @When("Create point using {string} {double} {double}")
    public void createPointUsing(String arg0, double arg1, double arg2) {
        Point first = new Point(arg0, arg1, arg2);
        System.out.println("Generated point 1");
    }

    @And("Create second point using {string} {double} {double}")
    public void createSecondPointUsing(String arg0, double arg1, double arg2) {
        Point second = new Point(arg0, arg1, arg2);
        System.out.println("Generated point 2");
    }

    @And("Calculate distance {string} {double} {double} {string} {double} {double}")
    public void calculateDistance(String arg0, double arg1, double arg2, String arg3, double arg4, double arg5) {
        Calculate distance1 = new Calculate(arg0, arg1, arg2, arg3, arg4, arg5);
        distance = distance1.getDst();
        System.out.println("Distance calculated!");
    }

    @Then("Distance equals {double}")
    public void distanceEquals(double wanted) {
        if (wanted == distance){
            System.out.println("Wanted distance is: " + wanted + " and calculated distance is: " + distance + ". \n Calculation correct!");
            System.out.println();
        }
        else {
            System.out.println("Wanted distance, which is: " + distance + " is different than calculated one, which is: " + wanted);
            System.out.println();
        }
    }
}
