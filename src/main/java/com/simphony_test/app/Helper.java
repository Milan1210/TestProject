package com.simphony_test.app;

import com.simphony_test.app.TestData.Data;
import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Helper
{
    public void setPropery(String key, String value){
        try {
            PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(Data.filesPath+"api.properties");
            propertiesConfiguration.setProperty(key,value);
            propertiesConfiguration.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String getPropery(String key){
        try {
            PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(Data.filesPath+"api.properties");
            return String.valueOf(propertiesConfiguration.getProperty(key));
        } catch (ConfigurationException e) {
            e.printStackTrace();
            return "There isn't value";
        }
    }

    public void validateResponse(String url){
        Response response = RestAssured.get(url);
        response.prettyPrint();
        long time = response.timeIn(TimeUnit.MILLISECONDS);
        Assert.assertTrue(response.statusCode()<310,"The Url is broken the status code for the url is: "+response.statusCode());
        Assert.assertTrue(time<4000,"It takes a along time to get resposne , the time for getting reposnse is "+time+" milisec");
    }
}
