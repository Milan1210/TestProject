package com.simphony_test.app.PageObjects;

import com.simphony_test.app.TestData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class AboutUsPage extends Utilize {
    @FindBy(css = "div>.pageMetaDetails")
    WebElement metaDetailstBox;

    @FindBy(xpath = "//strong[text()='HQ']/..")
    WebElement hqRow;

    @FindBy(xpath = "//strong[text()='Founded']/..")
    WebElement foundedRow;

    @FindBy(xpath = "//strong[text()='Consulting Offices']/..")
    WebElement consultingOfficesRow;

    @FindBy(xpath = "//strong[text()='Engineering Hubs']/..")
    WebElement engineeringHubsRow;

    @FindBy(xpath = "//strong[text()='Clients']/..")
    WebElement clientsRow;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public AboutUsPage checkLeftArticle() {
        MenuSideBar menuSideBar = new MenuSideBar(driver);
        menuSideBar.navigateToAboutUs();
        return this;
    }

    public AboutUsPage verifyValuesAndUrl() {
        waitForVisible(metaDetailstBox);
        WebElement hqValue = hqRow.findElement(By.tagName("p"));
        WebElement foundedValue = foundedRow.findElement(By.tagName("p"));
        List<WebElement> consultingOffices = consultingOfficesRow.findElements(By.tagName("p"));
        List<WebElement> engineeringHubs = engineeringHubsRow.findElements(By.tagName("p"));
        WebElement clientsValue = clientsRow.findElement(By.tagName("p"));

        assertString(hqValue.getText(), Data.HQ);
        assertString(foundedValue.getText(), Data.FOUNDED);
        assertArray(consultingOffices, Data.CONSULTING_OFFICES);
        assertArray(engineeringHubs, Data.ENGINEERING_HUBS);
        assertString(clientsValue.getText(), Data.CLIENTS);

        assertString(driver.getCurrentUrl(), Data.ABOUT_URL);
        return this;
    }

    public void assertArray(List<WebElement> currentValue, String[] expectedValue) {
        for (int i = 0; i < currentValue.size(); i++) {
            Assert.assertEquals(currentValue.get(i).getText(), expectedValue[i]);
        }
    }

}
