package Pages;

import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;


public class HomePage {

    WebDriver driver;

    private int selectedOptionOneValue;
    private int selectedOptionTwoValue;

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id = "salesresult")
    private WebElement salesresultField;

    @FindBy(id = "salestarget")
    private WebElement salestargetDropdwon;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "div[role='alert'] div:nth-child(1) span:nth-child(2)")
    private WebElement salesPeopleLabel;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private WebElement nameLabelOne;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private WebElement targetLabelOne;

    @FindBy(xpath = "//tbody/tr/td[3]")
    private WebElement resultLabelOne;

    @FindBy(xpath = "//tbody/tr/td[4]")
    private WebElement differenceLabelOne;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement nameLabelTwo;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement targetLabelTwo;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    private WebElement resultLabelTwo;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    private WebElement differenceLabelTwo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeTab;

    @FindBy(className = "btn-info")
    private WebElement showPerformanceButton;

    @FindBy(className = "performance")
    private WebElement performanceMessageOne;

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    private WebElement performanceMessageTwo;

    @FindBy(css = "div[role='alert'] div:nth-child(2) span:nth-child(2)")
    private WebElement expectedSalesLabel;

    @FindBy(css = "div[role='alert'] div:nth-child(3) span:nth-child(2)")
    private WebElement actualSalesLabel;

    @FindBy(css = "div[role='alert'] div:nth-child(4) span:nth-child(2)")
    private WebElement differenceLabel;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFirstname(String firstname) {
        Waits.getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(firstnameField));
        firstnameField.sendKeys(firstname);
    }

    public void fillLastname(String lastname) {
        lastnameField.sendKeys(lastname);
    }

    public void selectTargetOne() {
        Select select = new Select(salestargetDropdwon);
        select.selectByValue("80000");
        WebElement selectedOptionOne = select.getFirstSelectedOption();
        selectedOptionOneValue = Integer.parseInt(selectedOptionOne.getText().replace("$", "").replace(",", ""));
    }

    public void selectTargetTwo() {
        Select select = new Select(salestargetDropdwon);
        WebElement selectedOptionTwo = select.getFirstSelectedOption();
        selectedOptionTwoValue = Integer.parseInt(selectedOptionTwo.getText().replace("$", "").replace(",", ""));
    }

    public void fillSalesResult(int value) {
        salesresultField.sendKeys(String.valueOf(value));
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String verifySalesPeople() {
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(salesPeopleLabel));
        String peopleLabel = salesPeopleLabel.getText();
        return peopleLabel;
    }

    public String verifyNameLabelOne() {
        String nameL = nameLabelOne.getText();
        return nameL;
    }

    public String verifyTargetOne() {
        String target = targetLabelOne.getText();
        return target;
    }

    public String verifyResultOne() {
        String result = resultLabelOne.getText();
        return result;
    }

    public String verifyDifferenceOne() {
        String difference = differenceLabelOne.getText();
        return difference;
    }

    public String verifyNameLabelTwo() {
        String nameL = nameLabelTwo.getText();
        return nameL;
    }

    public String verifyTargetTwo() {
        String target = targetLabelTwo.getText();
        return target;
    }

    public String verifyResultTwo() {
        String result = resultLabelTwo.getText();
        return result;
    }

    public String verifyDifferenceTwo() {
        String difference = differenceLabelTwo.getText();
        return difference;
    }


    public String verifyTotalExpectedSales() {
        String totalSales = expectedSalesLabel.getText();
        return totalSales;
    }

    public String verifyTotalActualSales() {
        String totalResult = actualSalesLabel.getText();
        return totalResult;
    }

    public String verifyTotalDifference() {
        String totalDifference = differenceLabel.getText();
        return totalDifference;
    }

    public boolean homeTabIsSelected() {
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(homeTab));
        boolean isSelected = homeTab.getAttribute("class").contains("active");
        return isSelected;
    }

    public String showPerformanceMessageOne() {
        showPerformanceButton.click();
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(performanceMessageOne));
        String message = performanceMessageOne.getText();
        return message;
    }

    public String showPerformanceMessageTwo() {
        showPerformanceButton.click();
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(performanceMessageTwo));
        String message = performanceMessageTwo.getText();
        return message;
    }

    public String formatCurrency(int value) {
        DecimalFormat formatter = new DecimalFormat("$#,###");
        return formatter.format(value);
    }

    public int getSelectedOptionOneValue() {
        return selectedOptionOneValue;
    }

    public int getSelectedOptionTwoValue() {
        return selectedOptionTwoValue;
    }
}
