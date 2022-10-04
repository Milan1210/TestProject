package com.simphony_test.app.UI;

import com.simphony_test.app.Helper;
import com.simphony_test.app.TestData.Data;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.DriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void baseMethod() {
        switch (System.getProperty("browser")) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;

            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;

            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                driver = WebDriverManager.chromedriver().create();
                break;
        }
        driver.manage().window().maximize();
        new Helper().validateResponse(Data.baseURL);
        driver.get(Data.baseURL);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
