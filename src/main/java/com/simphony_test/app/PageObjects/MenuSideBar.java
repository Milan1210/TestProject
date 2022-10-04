package com.simphony_test.app.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSideBar extends Utilize {

    @FindBy(xpath = "//span[text()='About Us']")
    WebElement aboutUs;

    @FindBy(xpath = "//span[text()='Careers']")
    WebElement careers;

    public MenuSideBar(WebDriver driver) {
        super(driver);
    }

    public void navigateToAboutUs() {
        click(aboutUs);
    }

    public void navigateToCareers(String option) {
        mouseHover(careers);
        superClick(driver.findElement(By.xpath("//a[text()='" + option + "']")), 10);
    }
}
