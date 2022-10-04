package com.simphony_test.app.PageObjects;

import com.simphony_test.app.Helper;
import com.simphony_test.app.PageObjects.careers.CurrentOpeningsPage;
import com.simphony_test.app.TestData.Data;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends Utilize{


    public DashBoardPage(WebDriver driver){
        super(driver);
    }

    public AboutUsPage aboutUs(){
        MenuSideBar menuSideBar = new MenuSideBar(driver);
        menuSideBar.navigateToAboutUs();
        new Helper().validateResponse(driver.getCurrentUrl());
        return new AboutUsPage(driver);
    }

    public CurrentOpeningsPage careers(){
        MenuSideBar menuSideBar = new MenuSideBar(driver);
        menuSideBar.navigateToCareers(Data.curremtOpenings);
        return new CurrentOpeningsPage(driver);
    }


}
