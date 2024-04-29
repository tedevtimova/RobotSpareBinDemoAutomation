package Pages;

import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy (id = "firstname")
    private WebElement firstnameField;

    @FindBy (id = "lastname")
    private WebElement lastnameField;

    @FindBy (id = "salesresult")
    private WebElement salesresultField;

    @FindBy (id = "salestarget")
    private WebElement salestargetDropdwon;

    @FindBy (css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy (xpath = "//span[contains(text(),'1')]")
    private WebElement salesPeopleLabel;

    @FindBy (xpath = "//tbody/tr/td[1]")
    private WebElement nameLabel;

    @FindBy (xpath = "//tbody/tr/td[2]")
    private WebElement targetLabel;

    @FindBy (xpath = "//tbody/tr/td[3]")
    private WebElement resultLabel;

    @FindBy (xpath = "//tbody/tr/td[4]")
    private WebElement differenceLabel;

    @FindBy (xpath = "//a[contains(text(),'Home')]")
    private WebElement homeTab;

    @FindBy(xpath = "//a[contains(text(),'Order your robot!')]")
    WebElement nextTab;

    @FindBy (xpath = "//button[contains(text(),'OK')]")
    WebElement okButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillFirstname(String firstname){
        Waits.getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(firstnameField));
        firstnameField.sendKeys(firstname);
    }

    public void fillLastname(String lastname){
        lastnameField.sendKeys(lastname);
    }

    public void selectTarget(){
        Select select = new Select(salestargetDropdwon);
        select.selectByValue("80000");
    }

    public void fillSalesResult(int value){
        salesresultField.sendKeys(String.valueOf(value));
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String verifySalesPeople(){
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(salesPeopleLabel));
        String peopleLabel = salesPeopleLabel.getText();
        return peopleLabel;
    }

    public String verifyNameLabel(){
        String nameL = nameLabel.getText();
        return nameL;
    }

    public String verifyTarget (){
        String target = targetLabel.getText();
        return target;
    }

    public String verifyResult(){
        String result = resultLabel.getText();
        return result;
    }

    public String verifyDifference(){
        String difference = differenceLabel.getText();
        return difference;
    }

    public boolean homeTabIsSelected(){
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(homeTab));
        boolean isSelected = homeTab.getAttribute("class").contains("active");
        return isSelected;
    }
}
