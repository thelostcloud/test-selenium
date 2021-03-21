import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestGoogle {

    public String baseUrl = "https://www.google.com";
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
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
        driver.get(baseUrl);
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        TakesScreenshot screenie = (TakesScreenshot)driver;
        File screen1 =  screenie.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("/tmp/google.png");
        FileUtils.copyFile(screen1, DestFile);
        driver.close();
    }


}
