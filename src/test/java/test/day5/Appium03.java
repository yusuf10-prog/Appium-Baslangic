package test.day5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium03 {
    AndroidDriver<AndroidElement> driver;
     DesiredCapabilities capabilities=new DesiredCapabilities();

     @Test
    public void isCaculatorAppInstalled() throws MalformedURLException {
         capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
         capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
         capabilities.setCapability(MobileCapabilityType.VERSION,ConfigReader.getProperty("platformVersion"));
         capabilities.setCapability(MobileCapabilityType.APP,"/Users/yusuf/IdeaProjects/Appium_T120/Apps/Calculator_8.4.1 (520193683)_Apkpure.apk");

         driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

         Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

         driver.findElementByAccessibilityId("4").click();
         driver.findElementByAccessibilityId("5").click();
         driver.findElementByAccessibilityId("multiply").click();
         driver.findElementByAccessibilityId("9").click();
         driver.findElementByAccessibilityId("equals").click();

     }
}
