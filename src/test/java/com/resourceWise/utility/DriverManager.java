package com.resourceWise.utility;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;
    private String browser="chrome";


public DriverManager(){
    PageFactory.initElements(driver,this);
}
    public void openBrowser(){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver();

        }
}
    public void maxBrowser(){
        driver.manage().window().maximize();

    }
    public void handleCookies(){
    driver.findElement(By.linkText("GOT IT")).click();
    }
    public void navigateToHomePage(String url){
    driver.get(url);
    }
    public void closeBrowser(){
    driver.quit();
    }
    public void waitForPageLoad(){
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }
    public void applyiImplicitWait(){
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
    public void sleepBrowser(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitUntilElementClickable(WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver,30);
    return  webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public Boolean waitUntilElementInvisible(By by){
        return new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void takeScreenShot(Scenario scenario) {
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
//take a screen shot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("C:/Users/nares/Desktop/TestResult/Error.jpg"));
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


