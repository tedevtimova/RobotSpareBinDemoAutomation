package Tests;

import Helpers.TestNGHooks;
import Pages.HomePage;
import com.beust.jcommander.Parameter;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTests extends TestNGHooks {

    HomePage homePage;

    @Test(priority = 0)

    public void verifyHomePage(){
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.homeTabIsSelected(),"Home tab is not selected");
    }

    @Test(priority = 1)
    @Parameters ({"nameOne","nameTwo","targetValue"})

    public void fillInForm(String fname, String lname, int target){
        homePage.fillFirstname(fname);
        homePage.fillLastname(lname);
        homePage.selectTarget();
        homePage.fillSalesResult(target);
    }

    @Test(priority = 2)

    public void sumbit() throws InterruptedException {
        homePage.clickSubmit();
    }

    @Test(priority = 3)
    @Parameters ({"nameOne","nameTwo"})
    public void verifyFormResults(String fname, String lname) {
        Assert.assertEquals(homePage.verifySalesPeople(),"1","Sales person number does not match");
        Assert.assertEquals(homePage.verifyNameLabel(), fname + " " + lname, "Names do not match");
        Assert.assertEquals(homePage.verifyTarget(),"$80,000","Target value does not match");
        Assert.assertEquals(homePage.verifyResult(),"$100,000","Result value does not match");
        Assert.assertEquals(homePage.verifyDifference(),"$20,000","Difference value does not match");
    }
}
