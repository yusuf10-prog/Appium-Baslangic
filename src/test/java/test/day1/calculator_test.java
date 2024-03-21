package test.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class calculator_test {
    AndroidDriver<AndroidElement> driver; // Android driver sadece android cihazlar icin olusturulmus bir driverdir.
    // Android cihazla icin gerekli olan hazir methodlari bu driver ile birlikte kullanarak cihaz ile ilgili islemleri yapabiliriz.

    AppiumDriver<MobileElement> driver2;
    //Appdriver ise hem Ios hem de Android isletim sistemine sahip olan cihazlar icin tasrlanmistir. Bu driver ile birlikte
    // iki farkli platform da driver ile islemlerimizi gerçeklestirebiliriz.

    // EN TEMEL FARK !!!!! Android cihazlar kullanim farkliliklari daha zengin oldugu icin AndroidDriver sadece android cihazlara
    // özel tasalanmistir. Bu da bizlere android cihazlar daha kulllanisli bir driver kullanmamiza fayda sağlar.


    @Test
    public void apkYukleme() throws MalformedURLException {


        // kullanici gerekli kurulumlari yapar

            // kullanici gerekli kurulumlari yapar
            DesiredCapabilities capabilities=new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP,"/Users/yusuf/IdeaProjects/Appium_T120/Apps/Calculator_8.4.1 (520193683)_Apkpure.apk");
            //capabilities.setCapability(MobileCapabilityType.APP, "/Users/yusuf/IdeaProjects/Appium_T120/Apps/Apk Bilgisi_2.3.4_apkcombo.com (1).apk");

            driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        // uygulamanin yuklendigini dogrular(isInstalled)

        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        //com.google.android.calculator

        // uygulamanin acildigini dogrular

        Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());

        // 100 un 5 katininin 500 oldugunu hesap makinasindan dogrulayali

        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
       // driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementByAccessibilityId("5").click();

        String sonucKutusu=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(sonucKutusu);

        Assert.assertEquals(Integer.parseInt(sonucKutusu),51);

    }
}