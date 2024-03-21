package test.day4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class allCurrencyApp {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyAppPage page=new AllCurrencyAppPage();

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter");

        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(page.currentText.isDisplayed());

        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.tiklamaMethodu(369,321,50);
        ReusableMethods.scrollWithUiScrollable("ALL");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.tiklamaMethodu(365,468,50);
        ReusableMethods.scrollWithUiScrollable("AED");
        page.oneButton.click();


        for (int i=0; i<3; i++){
            page.zeroButton.click();
        }

        // cevrilen tutar screenShot olarak kaydedilir
        File paraSonucu=driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(paraSonucu,new File("zlotyToTry.jpg"));

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String ceviriSonucu= page.resultBox.getText();
        // kullaniciya sms olarak bildirilir
        driver.sendSMS("222222222222", "Suan icin cevirisini yaptiginiz kur sonucu : " + ceviriSonucu);
    }
}
