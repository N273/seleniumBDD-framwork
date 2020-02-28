package com.resourceWise;

import com.resourceWise.utility.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager driverManager=new DriverManager();
    @Before
    public void setUp() {
        driverManager.openBrowser();
        driverManager.navigateToHomePage("https://www.argos.co.uk");
        driverManager.maxBrowser();
        driverManager.waitForPageLoad();
        driverManager.applyiImplicitWait();
        driverManager.handleCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            driverManager.takeScreenShot(scenario);
        }
        driverManager.closeBrowser();
    }
}
