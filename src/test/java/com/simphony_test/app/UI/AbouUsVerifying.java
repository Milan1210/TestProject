package com.simphony_test.app.UI;

import com.simphony_test.app.PageObjects.DashBoardPage;
import com.simphony_test.app.PageObjects.Utilize;
import org.testng.annotations.Test;

public class AbouUsVerifying extends BaseTest {

    @Test(priority = 0)
    public void checkAboutUs(){
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.aboutUs()
                .checkLeftArticle()
                .verifyValuesAndUrl();

    }

    @Test
    public void test(){
        Utilize utilize = new Utilize(driver);
        utilize.readFromXmlFile1("data","ss");

    }
}
