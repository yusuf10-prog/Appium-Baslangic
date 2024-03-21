package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AndroidDriver<AndroidElement> appiumDriver;
    //apiumDriver'ı neden private olarak yapıyoruz. private ile sadece bu class da kullanılması için yapıyoruz.

    static final String TELEFONADI="PIXEL2";
    // Neden final olarak tanımlıyoruz.
    // Tekrardan bu degere atama isleminin yapılmaması icin final yapıyoruz.
    static final String ANDROIDVERSION="13.0";
    static final String PLATFORM="Android";
    static final String OTOMASYON_ISMI="UiAutomator2";


    public static AndroidDriver getAndroidDriver(){

        // public diger class lardan kullanılmasını saglıyoruz.


        URL appiumServerURL=null;
        try {
            appiumServerURL=new URL("http:127.0.0.1:4723/wd/hub");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        if (appiumDriver == null){
            // appiumDriver degerim null ise aşagidaki islemleri gerçeklestir.

            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, TELEFONADI);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROIDVERSION);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, OTOMASYON_ISMI);
            caps.setCapability(MobileCapabilityType.UDID,"ea3e6f63");
            caps.setCapability("appPackage","com.smartwho.SmartAllCurrencyConverter");
            caps.setCapability("appActivity","com.smartwho.SmartAllCurrencyConverter.CurrencyConverter");
            caps.setCapability(MobileCapabilityType.NO_RESET,false);
            // true olarak sectigimizde uygulamayı sıfırlamıyor onceki adimları muhafaza ediyor
            // false ise her test baslangicinda sıfırlıyor

            if (ConfigReader.getProperty("platformName").equals("Android")){
                // configReader a gidip platform name android oldugunu kontrol eder.
                // kontrol isleminden sonra if blogunu calıstırma islemini yapar.

                assert appiumServerURL != null;
                // appiumServerURL in boş olmadığını kontrol ediyoruz.

                appiumDriver=new AndroidDriver<AndroidElement>(appiumServerURL,caps);

                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            }else {
                throw new UnsupportedOperationException("Invalid Platform Name ");
                // platform name yanlıs girildi ise burayı dondurecek.
            }
        }
        return appiumDriver;
    }
    public static void quitAppiumDriver(){
        if (appiumDriver !=null){
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}
