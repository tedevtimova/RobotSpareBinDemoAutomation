package Tests;

import Helpers.TestNGHooks;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestNGHooks {

    LoginPage loginPage;

    @Test(priority = 0)

    public void fillInLogin(){
        loginPage = new LoginPage(driver);
    loginPage.fillInLoginForm("maria", "thoushallnotpass");

    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        loginPage.clickLogin();
    }

}
