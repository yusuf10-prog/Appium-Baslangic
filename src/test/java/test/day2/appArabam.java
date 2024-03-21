package test.day2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class appArabam {

    AndroidDriver<AndroidElement>driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");
        // appPackage bir uygulaminin kimlik bilgisidir. Biz bu capability sayesinde
        // hangi uygulama uzerinden calisacagimizii test oncesinde belirtebiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appActivity uzerinde calisacak oldugumuz uygulamanin hangi sayfa penceresinden baslayacagimizi belirtir.
        // yani biz bu capabilitiy sayesinde uygulama içersindeki farkli pencerelerden uygulamayi baslatabiliriz.
        // Bunun icin gerekli activity degerlerine sahip olmamiz gerekir.


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @Test
    public void arabamAppTest() throws InterruptedException {
      //  driver.activateApp("com.dogan.arabam");

        // uygulamanin basarili bir sekilde acildigi dogrulanir.
        Assert.assertTrue(driver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());

        //alt menuden ilan ara butonuna tiklanir.
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        Thread.sleep(2000);

        // kategori olarak otomobil secilir.
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir.
        Thread.sleep(10000);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(508, 1538))
                // press kismi ekranda tiklama kaydirma islemi icin tiklama yapacagimiz ilk nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                // baslangic noktasi ile bitis noktasi arasinda gecen süre
                // eger wait süresi uzun olursa gidilen yol mesafesi daha AZ olacaktir.
                // eger ki wait süresi kisa olursa gidilen yol mesafesi daha FAZLA olacaktir.
                .moveTo(PointOption.point(508, 398))
                // baslangic noktasindan baslayarak gidilecek bitis noktasinin koordinatlarini ifade eder
                        .release()
                // parmagimizi tipki günlük kullanimdaki gibi ekrandan kaldirma serbest birakma eylemidir.
                                .perform();
        Thread.sleep(10000);
        // verilen action gorevlerini yerine getirmesi icin actiona verilen emirdir!


        action.press(PointOption.point(244,1150))
                .release()
                .perform();

        Thread.sleep(1000);

        driver.findElementByXPath("//*[@text='Passat']").click();
        // arac markasi olarak passat secilir.
       // driver.findElementByXPath("//*[@text='Tata']").click();

        // 1.4 TSI
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir.
        driver.findElementByXPath("//*[@text='Highline']").click();
        Thread.sleep(750);

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir.
        driver.findElementById("com.dogan.arabam:id/imageViewSorting").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // gelen en ucuz aracin 500.000 tl den büyük oldugu dogrulanir

        Thread.sleep(5000);

        String aracFiyati=driver.findElementByXPath("//*[@resource-id=\"com.dogan.arabam:id/tvPrice\"]").getText();
        System.out.println(aracFiyati);

        //Assert.assertTrue(Integer.parseInt(aracFiyati>500000));

       // aracFiyati=aracFiyati.replaceAll(".","").replaceAll(" TL", "");                    

        aracFiyati=aracFiyati.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(aracFiyati)>800000);

    }
}
