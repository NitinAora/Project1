package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestCases extends BaseClass {
    //IOSDriver driver =new IOSDriver();
    @Test
    public void sixty() {
       // iosDriverr.get("https://google.com");

        iosDriverr.findElementByAccessibilityId("Alert Views").click();
        iosDriverr.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
        iosDriverr.findElementByXPath("//XCUIElementTypeCell").sendKeys("Hello");
        iosDriverr.findElementByAccessibilityId("OK").click();

        iosDriverr.findElementByAccessibilityId("Confirm / Cancel").click();
        String str =iosDriverr.findElementByAccessibilityId("A message should be a short, complete sentence.").getText();
        System.out.println("str = " + str);
        Assert.assertEquals("A message should be a short, complete sentence.", str);
        iosDriverr.findElementByAccessibilityId("Confirm").click();

    }

    @Test
    public void SixtyOnescrollFunctionality() throws InterruptedException {

        HashMap<String,Object> scrollObject= new HashMap<>();

        scrollObject.put("direction", "down");
        scrollObject.put("value","Web View");

        iosDriverr.executeScript("mobile:scroll",scrollObject);
        iosDriverr.findElementByAccessibilityId("Web View").click();
        Thread.sleep(4000);
        String str = iosDriverr.findElementByXPath("//XCUIElementTypeStaticText").getText();

        Assert.assertEquals(str,"Web View" );
        Thread.sleep(3000);
        iosDriverr.findElementByXPath("//XCUIElementTypeButton[@name='UIKitCatalog']").click();
        iosDriverr.findElementByAccessibilityId("Picker View").click();
        iosDriverr.findElementByAccessibilityId("Red color component value").sendKeys("80");
        iosDriverr.findElementByAccessibilityId("Green color component value").sendKeys("220");
        iosDriverr.findElementByAccessibilityId("Green color component value").sendKeys("105");


    }

    @Test
    public void slidersTest(){
        iosDriverr.findElementByAccessibilityId("Sliders").click();
        IOSElement slider=(IOSElement) iosDriverr.findElementByXPath("//XCUIElementTypeSlider");
        slider.setValue("0%");
        slider.setValue("1%");
        Assert.assertEquals("100%", slider.getAttribute("value"));
    }




}
