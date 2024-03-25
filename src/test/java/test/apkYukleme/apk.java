package test.apkYukleme;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apk {

    AndroidDriver<AndroidElement>driver;
    @Test
    public void apkYukleme() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
       // capabilities.setCapability(MobileCapabilityType.UDID,"ea3e6f63");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/yusuf/IdeaProjects/Appium_T120/Apps/Yukato Drivers_10.168_apkcombo.com.apk");
       // capabilities.setCapability(MobileCapabilityType.APP, "/Users/yusuf/IdeaProjects/Appium_T120/Apps/Apk Bilgisi_2.3.4_apkcombo.com (1).apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
}
