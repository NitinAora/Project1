package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.IThreadFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    IOSDriver iosDriverr;
    AndroidDriver androidDriverr;

    @BeforeTest
    public void setup() throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String device = "iOS";
            if (device.equals("iOS")) {
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 12 Pro");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
                capabilities.setCapability("commandTimeouts", "12000");
               // capabilities.setCapability(MobileCapabilityType.APP, "/Users/nitinarora/Library/Developer/Xcode/DerivedData/UIKitCatalog-csqyytshyksqfjhdqcvaurkqbmjl/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
                capabilities.setCapability(MobileCapabilityType.UDID, "459E4F19-4013-4947-9AED-FD3336091E59");
                iosDriverr = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
                // return driver;
            } else if (device.equals("android")) {
                File f = new File("src");
                File fs = new File(f, "General-Store.apk");
               // File fs = new File(f, "ApiDemos-debug.apk");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API S");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
                capabilities.setCapability("commandTimeouts","19000");
                capabilities.setCapability(MobileCapabilityType.APP, "/Users/nitinarora/IdeaProjects/Project1/src/General-Store.apk");
                //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
                //capabilities.setCapability(MobileCapabilityType.APP, "/Users/nitinarora/IdeaProjects/Project1/src/ApiDemos-debug.apk");
                androidDriverr = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                androidDriverr.findElementByXPath("//android.widget.Button[@text='OK']").click();
            }
        } catch (Exception execption) {
            System.out.println("execption = " + execption.getCause());
            System.out.println("execption = " + execption.getMessage());
            execption.printStackTrace();
        }
    }

    @Test
    public void twentytwothree() {

        androidDriverr.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        androidDriverr.findElementByAccessibilityId("3. Preference dependencies").click();
        androidDriverr.findElementById("android:id/checkbox").click();
        androidDriverr.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        androidDriverr.findElementByClassName("android.widget.EditText").sendKeys("hello");
        androidDriverr.findElementById("android:id/button1").click();
        // androidDriverr.findElementById("android:id/title").click();
    }

    @Test
    public void twentyFour() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        androidDriverr.findElementByAndroidUIAutomator("text(\"Animation\")").click();
    }

    @Test
    public void twentySix() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        TouchAction t = new TouchAction(androidDriverr);
        WebElement webElement = androidDriverr.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement))).perform();
    }

    @Test
    public void twentySeven() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        TouchAction t = new TouchAction(androidDriverr);
        WebElement webElement = androidDriverr.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement))).perform();
        WebElement webElement1 = androidDriverr.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement1))).perform();
        WebElement webElementt = androidDriverr.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(webElementt)).withDuration(Duration.ofSeconds(2))).release().perform();
    }

    @Test
    public void twentyEightNine() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        TouchAction t = new TouchAction(androidDriverr);
        WebElement webElement = androidDriverr.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement))).perform();
        WebElement webElement1 = androidDriverr.findElementByXPath("//android.widget.TextView[@text='2. Inline']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement1))).perform();
        WebElement webElement9 = androidDriverr.findElementByXPath("//*[@content-desc='9']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement9))).perform();
        WebElement webElement15 = androidDriverr.findElementByXPath("//*[@content-desc='15']");
        WebElement webElement45 = androidDriverr.findElementByXPath("//*[@content-desc='45']");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(webElement15)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(webElement45)).release().perform();
    }

    @Test
    public void thirty() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        androidDriverr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }

    @Test
    public void thirtyOne() {
        androidDriverr.findElementByAndroidUIAutomator("text(\"Views\")").click();
        androidDriverr.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        TouchAction t = new TouchAction(androidDriverr);
        WebElement source = (WebElement) androidDriverr.findElementsByClassName("android.view.View").get(0);
        WebElement destination = (WebElement) androidDriverr.findElementsByClassName("android.view.View").get(1);
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source))).moveTo(ElementOption.element(destination)).release().perform();
    }

    @Test
    public void thirtyEight() throws InterruptedException {
        Thread.sleep(4000);
        androidDriverr.findElementById("android:id/text1").click();
        androidDriverr.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Egypt" + "\").instance(0))"));
        //androidDriverr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));");
        androidDriverr.findElementByXPath("//android.widget.TextView[@text='Egypt']").click();
        androidDriverr.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("dulu");
        androidDriverr.hideKeyboard();
        androidDriverr.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

    }

    @Test
    public void thirtyNineForty() throws InterruptedException {
        Thread.sleep(4000);
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String errorMessage=  androidDriverr.findElementByXPath("//android.widget.Toast[1]").getText();
        System.out.println(errorMessage);
        Assert.assertEquals(errorMessage,"Please enter your name");
    }
    @Test
    public void fortyThree() throws InterruptedException {
        System.out.println("hello");
        androidDriverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriverr.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("dulu");
        androidDriverr.hideKeyboard();
        androidDriverr.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        androidDriverr.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan Lift Off\").instance(0))"));

        //ask bharat - line 187 - i cant select the second add to cart option. we can't use elementsbyid and then get.gettext or etc uncomment
      //  the below code and see

     /*   int count=    androidDriverr.findElementsById("com.androidsample.generalstore:id/productName").size();
        for(int i=0;i<count;i++) {
            String text = androidDriverr.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if (text.equalsIgnoreCase("Jordan 6 Rings")) {
                androidDriverr.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        */

        int flag=0;
        List<WebElement> elementName=androidDriverr.findElementsById("com.androidsample.generalstore:id/productName");
        for (int i = 0; i < elementName.size(); i++) {
            System.out.println("elementName = " + elementName.get(i).getText());
            System.out.println("SIZE %%%%%%%%%%%"+elementName.size());

            if(elementName.get(i).getText().equals("Jordan Lift Off")) {
                flag = i;
                System.out.println("flag bbbbb= " + flag);
                break;
            }
        }
        System.out.println("fdghjsdfh");
        System.out.println("//*[@text='ADD TO CART']["+flag+"]");
        androidDriverr.findElementByXPath("//*[@text='ADD TO CART'][2]").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(3000);
        String lastpageText= androidDriverr.findElementById("com.androidsample.generalstore:id/productName").getText();
        System.out.println("dddd"+lastpageText);
        Assert.assertEquals("Jordan Lift Off", lastpageText);
    }
    //ask bharat line 209 not able to locate the element
    @Test
    public void fortySeven() throws InterruptedException {
        System.out.println("hello");
        androidDriverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriverr.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("dulu");
        androidDriverr.hideKeyboard();
        androidDriverr.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        androidDriverr.findElementByXPath("//*[@text='ADD TO CART']").click();
        androidDriverr.findElementByXPath("//*[@text='ADD TO CART']").click();

        androidDriverr.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        String item1=androidDriverr.findElementByXPath("//android.widget.TextView[@text='$120.0']").getText();
        System.out.println("first"+item1);
        item1= item1.substring(1);
        System.out.println(item1);
        Double p1= Double.parseDouble(item1);
        System.out.println(item1);
        String item2= androidDriverr.findElementByXPath("//android.widget.TextView[@Text='$160.97']").getText();
        item2= item2.substring(1);

        Double p2= Double.parseDouble(item2);
        Double p3=p1+p2;
        String p4=p3.toString();
        String total=androidDriverr.findElementByXPath("//android.widget.TextView[@text=' 280.97']").getText();
        total=total.substring(1);
        System.out.println(p4);
        System.out.println(total);
        Assert.assertEquals(p4,total);

        Thread.sleep(3000);
        String lastpageText= androidDriverr.findElementById("com.androidsample.generalstore:id/productName").getText();
        System.out.println("dddd"+lastpageText);
        //Assert.assertEquals("Jordan Lift Off", lastpageText);
    }

    @Test
    public void fiftyoneAandtwo() throws InterruptedException {
        androidDriverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriverr.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("dulu");
        androidDriverr.hideKeyboard();
        androidDriverr.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        androidDriverr.findElementByXPath("//*[@text='ADD TO CART']").click();
        androidDriverr.findElementByXPath("//*[@text='ADD TO CART']").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        WebElement checkbox= androidDriverr.findElementByClassName("android.widget.CheckBox");
        TouchAction t= new TouchAction(androidDriverr);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();
        WebElement tc=androidDriverr.findElementByXPath("//*[@text='Please read our terms of conditions']");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        androidDriverr.findElementById("android:id/button1").click();
        androidDriverr.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(7000);
        Set<String> contexts= androidDriverr.getContextHandles();
        for (String contextName:contexts) {
            System.out.println(contextName);
        }
        androidDriverr.context("WEBVIEW_com.androidsample.generalstore");
        //ask bharat not able to locate element in web view and send keys
        Thread.sleep(5000);
        androidDriverr.findElementByClassName("android.widget.EditText").sendKeys("hrlls");
       // WebDriver d =new ChromeDriver();
        // androidDriverr.findElement(By.id("q")).sendKeys("hello");
    }

    @Test
    public void fiftyOne(){
        //androidDriverr
    }

    @AfterTest
    public void teardown() {
        System.out.println("hello = ");
        // driver.close();
        //  driver.quit();
    }
}
