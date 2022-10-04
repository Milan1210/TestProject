package com.simphony_test.app.PageObjects;

import com.simphony_test.app.TestData.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.Duration;

public class Utilize extends Data {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public Utilize(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void superClick(WebElement element, int sec) {
        for (int i = 0; i < sec; i++) {
            try {
                element.click();
                break;
            } catch (NoSuchElementException e) {
                sleep(1000);
                e.getMessage();
            }
        }
    }

    public void superWait(WebElement element, int sec) {
        for (int i = 0; i < sec; i++) {
            try {
                if (element.isDisplayed())
                    break;
            } catch (NoSuchElementException e) {
                sleep(1000);
                e.getMessage();
            }
        }
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void mouseHover(WebElement element) {
        waitForVisible(element);
        actions.moveToElement(element).perform();
    }

    public void assertString(String actual, String expected) {
        Assert.assertEquals(actual, expected, "String is not matches");
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readFromXmlFile(String section, String element) {
        String basePath = System.getProperty("user.dir");
        System.out.println("aaa " + basePath);
        File file = new File(basePath + "\\resources\\files\\data.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodeList = doc.getElementsByTagName(section);
            Node node = nodeList.item(0);
            Element eElement = (Element) node;
            System.out.println("hq is " + eElement.getElementsByTagName(element).item(0).getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromXmlFile1(String section, String element) {
        String basePath = System.getProperty("user.dir");
        System.out.println("aaa " + basePath);
        File file = new File(basePath + "\\resources\\files\\data.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Element element1 = doc.getDocumentElement();
            System.out.println("Element of QA is " + element1.getElementsByTagName("hq").item(1).getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public PrintWriter writeToFile(String s1, String s2) throws FileNotFoundException {
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath + "\\resources\\files\\all_positions.txt");
        try {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println("S1 " + s1 + " String s2 " + s2);
//            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new PrintWriter(file);
    }
}
