package com.simphony_test.app.PageObjects.careers;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.simphony_test.app.Helper;
import com.simphony_test.app.PageObjects.Utilize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

public class CurrentOpeningsPage extends Utilize {
    @FindBy(xpath = "//h3[text()='Current Openings']")
    WebElement title;

    @FindBy(css = "ul.currentOpenings--jobs")
    WebElement currentOpeningJobsBox;

    static List<WebElement> positions;
    static String[][] getTheTitleAndLocationArray;
    public CurrentOpeningsPage(WebDriver driver) {
        super(driver);
    }

    public CurrentOpeningsPage countAllOpenedPositions(){
        superWait(title,5);
        positions = currentOpeningJobsBox.findElements(By.tagName("a"));
        int numberOfAllPostition = positions.size();

        Assert.assertTrue(numberOfAllPostition>0);
        return new CurrentOpeningsPage(driver);
    }

    public CurrentOpeningsPage checkUrls(){
        superWait(title,5);
        positions = currentOpeningJobsBox.findElements(By.tagName("a"));
        for (WebElement e:positions) {
            new Helper().validateResponse(e.getAttribute("href"));
        }

        return new CurrentOpeningsPage(driver);
    }

    public CurrentOpeningsPage getTheTitleAndLocation(){
        getTheTitleAndLocationArray = new String[positions.size()][2];
        for (int i = 0; i<positions.size(); i++){
            getTheTitleAndLocationArray[i][0] = positions.get(i).findElement(By.cssSelector("div.currentOpenings--job-title")).getText();
            getTheTitleAndLocationArray[i][1] = positions.get(i).findElement(By.cssSelector("div.currentOpenings--job-locationWrapper")).getText();
        }

        for (int i = 0; i<positions.size(); i++){
            System.out.println("Title is / "+getTheTitleAndLocationArray[i][0] + " / Position is / "+getTheTitleAndLocationArray[i][1]);
        }
        return this;
    }

    public void writeTitleAndLocationToFile() {
        String basePath = System.getProperty("user.dir");
        File file = new File(filesPath+"all_positions.txt");
            try {
                PrintWriter writer = new PrintWriter(file,"UTF-8");
                for (int i = 0; i < positions.size(); i++) {
                    writer.println(getTheTitleAndLocationArray[i][0] + " , " + getTheTitleAndLocationArray[i][1] );
                }
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }

    }

}
