
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.IAssert;


import java.net.URL;

public class TestOne {

    public String baseUrl = "http://demo.guru99.com/test/newtours/";
//    String driverPath = "C:\\geckodriver.exe";
    public WebDriver driver ;


    @Test
    public void verifyHomepageTitle() throws IOException {

        DesiredCapabilities dr = new DesiredCapabilities();
//specify the browser
        dr.setBrowserName("chrome");
//specify the environment
        dr.setPlatform(Platform.LINUX);

        System.out.println("launching firefox browser");
//        System.setProperty("webdriver.gecko.driver", driverPath);
//        driver = new RemoteWebDriver(new URL("http://docker-20:4444/wd/hub"), dr);
        driver = new RemoteWebDriver(new URL("http://host.docker.internal:4444/wd/hub"), dr);
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        TakesScreenshot screenie = (TakesScreenshot)driver;
        File screen1 =  screenie.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("/tmp/test.png");
        FileUtils.copyFile(screen1, DestFile);
        driver.close();
    }


}
