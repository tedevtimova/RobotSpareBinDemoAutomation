package Tests;

import Helpers.TestNGHooks;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTests extends TestNGHooks {

    int count;

    HomePage homePage;

    @Test(priority = 0)

    public void verifyHomePage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.homeTabIsSelected(), "Home tab is not selected");
    }

    @Test(priority = 1)
    @Parameters({"firstNameOne", "secondNameOne", "resultValueOne"})

    public void fillInFormFirstUser(String fname, String lname, int result) {
        homePage.fillFirstname(fname);
        homePage.fillLastname(lname);
        homePage.selectTargetOne();
        homePage.fillSalesResult(result);
    }

    @Test(priority = 2)

    public void submitFirstUser() {
        homePage.clickSubmit();
        count++;
    }

    @Test(priority = 3)
    @Parameters({"firstNameOne", "secondNameOne", "resultValueOne"})
    public void verifyFirstUserFormResults(String fname, String lname, int result) {

        Assert.assertEquals(homePage.verifyNameLabelOne(), fname + " " + lname, "Names do not match");
        Assert.assertEquals(homePage.verifyTargetOne(), "$80,000", "Target value does not match");
        Assert.assertEquals(homePage.verifyResultOne(), homePage.formatCurrency(result), "Result value does not match");
        Assert.assertEquals(homePage.verifyDifferenceOne(), "$20,000", "Difference value does not match");
    }

    @Test(priority = 4)

    public void verifyFirstUserResultMessage() {
        Assert.assertEquals(homePage.showPerformanceMessageOne(), "A positive result. Well done!", "Performance message is not the expected one");
    }

    @Test(priority = 5)
    @Parameters({"firstNameTwo", "secondNameTwo", "resultValueTwo"})

    public void fillInFormSecondUser(String fnameTwo, String lnameTwo, int resultTwo) {
        homePage.fillFirstname(fnameTwo);
        homePage.fillLastname(lnameTwo);
        homePage.selectTargetTwo();
        homePage.fillSalesResult(resultTwo);
    }

    @Test(priority = 6)
    public void submitSecondUser() {
        homePage.clickSubmit();
        count++;
    }

    @Test(priority = 7)
    @Parameters({"firstNameTwo", "secondNameTwo", "resultValueTwo"})
    public void verifySecondUserFormResults(String fname, String lname, int result) {
        Assert.assertEquals(homePage.verifyNameLabelTwo(), fname + " " + lname, "Names do not match");
        Assert.assertEquals(homePage.verifyTargetTwo(), "$5,000", "Target value does not match");
        Assert.assertEquals(homePage.verifyResultTwo(), homePage.formatCurrency(result), "Result value does not match");
        Assert.assertEquals(homePage.verifyDifferenceTwo(), "$-3,000", "Difference value does not match");
    }

    @Test(priority = 8)

    public void verifySecondUserResultMessage() {
        Assert.assertEquals(homePage.showPerformanceMessageTwo(), "Oh dear.", "Performance message is not the expected one");
    }

    @Test(priority = 9)
    @Parameters({"resultValueOne", "resultValueTwo"})
    public void verifyTotalUsersResults(int oneResult, int twoResult) {
        int totalTarget = homePage.getSelectedOptionOneValue() + homePage.getSelectedOptionTwoValue();
        int totalResult = oneResult + twoResult;
        int difference = totalResult - totalTarget;
        Assert.assertEquals(homePage.verifySalesPeople(), Integer.toString(count), "Sales person number does not match");
        Assert.assertEquals(homePage.verifyTotalExpectedSales(), homePage.formatCurrency(totalTarget), "Expected sales value does not match");
        Assert.assertEquals(homePage.verifyTotalActualSales(), homePage.formatCurrency(totalResult), "Actual sales value does not match");
        Assert.assertEquals(homePage.verifyTotalDifference(), homePage.formatCurrency(difference), "Total Difference value does not match");
    }
}
