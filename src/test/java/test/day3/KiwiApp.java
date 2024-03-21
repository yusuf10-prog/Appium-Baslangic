package test.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.management.relation.RelationSupport;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    KiwiPages pages=new KiwiPages();
    @Test
    public void kiwiAppTest() throws InterruptedException {
        //uygulamanın yüklendigi dogrulanir.
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir.
        Assert.assertTrue(pages.misafirButonu.isDisplayed());
        // misafir olaark devam et e tiklanir
        pages.misafirButonu.click();
        //ardindan gelecek olan 3 adimada yesil butona basilarak devam edilir.
        // 544 , 1691
        TouchAction action=new TouchAction<>(driver);
        for (int i=0; i<5; i++){
            ReusableMethods.tiklamaMethodu(554,1692,2000);
        }
        // Trip type, one way olarak secilir.
        Thread.sleep(3000);
        ReusableMethods.tiklamaMethodu(274,617,100);
        Thread.sleep(5000);


            pages.oneWayButton.click();
            Thread.sleep(5000);
        Thread.sleep(3000);
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir.
        ReusableMethods.tiklamaMethodu(208,779,750);
        Thread.sleep(2000);
        ReusableMethods.tiklamaMethodu(1016,139,1000);
       // ReusableMethods.screenScroolDownMethod(500,750,75,500,750,0);
        // kalkis yapilacak ulke / sehir girilir ve sec e tiklanir.

        if(!driver.isKeyboardShown()){
            pages.aramaKutusu.sendKeys("istanbul");
            // klavyem gözükmüyorsa istanbul yazacak.
        }else {
            driver.getKeyboard().pressKey("Ankara");
            // klavyem gözüküyorsa ankara yı yazacak.
        }
        Thread.sleep(5000);

        ReusableMethods.tiklamaMethodu(369,292,1000);
        pages.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir 369, 292
        pages.anywhereButton.click();
        driver.getKeyboard().pressKey("Varsova");

        ReusableMethods.tiklamaMethodu(369,292,1000);
        pages.chooseButton.click();
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir.
        pages.anyTimeButton.click();

        // 541, 1341
        //Thread.sleep(5000);
       // ReusableMethods.screenScroolDownMethod(541,1341,8000,548,482,75);

        ReusableMethods.tiklamaMethodu(672,1140,1000);

        // search butonuna tiklanir
        pages.searchButton.click();

        // en ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(259,259,750);
        ReusableMethods.tiklamaMethodu(409,584,750);
        pages.stopButton.click();
        pages.nanstopButton.click();

        // gelen bilet fiyati kaydedilir ve kullanicinin telefonuna sms olarak gonderilir
        String fiyat=pages.priceBox.getText();
        driver.sendSMS("1111111111111", "Bu ucus icin fiyatiniz : " + fiyat);
    }
}
