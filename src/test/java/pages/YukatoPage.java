package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class YukatoPage {
    public YukatoPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Giriş Yapın']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//*[@text='53X XXX XX XX']")
    public WebElement phone;
}
