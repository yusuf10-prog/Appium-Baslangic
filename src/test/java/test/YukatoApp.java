package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pages.YukatoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class YukatoApp {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    YukatoPage page=new YukatoPage();
    @Test
    public void YukatoTest() throws InterruptedException {

        page.girisYapButton.click();
        page.phone.click();
        //driver.findElementByXPath("//android.widget.EditText").click();
        driver.findElementByXPath("//android.widget.EditText").sendKeys("5550679255");

/*

        for (int i=0; i<3; i++){
            ReusableMethods.tiklamaMethodu(406,1415,1000); // 3x5
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        ReusableMethods.tiklamaMethodu(409,1722,1000); //0
        ReusableMethods.tiklamaMethodu(679,1425,1000); //6
        ReusableMethods.tiklamaMethodu(135,1560,1000); //7
        ReusableMethods.tiklamaMethodu(676,1557,1000); //9
        ReusableMethods.tiklamaMethodu(402,1267,1000); //2
        for (int i=0; i<2; i++){
            ReusableMethods.tiklamaMethodu(406,1415,1000); //2x5
        }

 */
    }
}
