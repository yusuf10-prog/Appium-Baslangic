package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyAppPage {
    public AllCurrencyAppPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement currentText;

    @FindBy(id= "com.smartwho.SmartAllCurrencyConverter:id/bResult")
    public WebElement oneButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement zeroButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement resultBox;


}
