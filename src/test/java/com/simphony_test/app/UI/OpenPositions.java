package com.simphony_test.app.UI;

import com.simphony_test.app.PageObjects.DashBoardPage;
import org.testng.annotations.Test;

public class OpenPositions extends BaseTest {

    @Test(priority = 1)
    public void countAndStoreAllOpenedPostitions(){
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage
                .careers()
                .countAllOpenedPositions()
                .checkUrls()
                .getTheTitleAndLocation()
                .writeTitleAndLocationToFile();
    }

}
