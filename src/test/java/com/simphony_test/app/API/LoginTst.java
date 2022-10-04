package com.simphony_test.app.API;

import com.simphony_test.app.API.data.DataProviderTst;
import com.simphony_test.app.API.data.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class LoginTst extends TestData {

    @Test(priority = 6,dataProvider = "Login", dataProviderClass = DataProviderTst.class)
    public void Login(String usrname, String pwd){
        baseURI=BASE_URL;
        basePath=BASE_PATH;

        Map<String,String> body = new HashMap<>();
        body.put("username",usrname);
        body.put("password",pwd
        );

        Response response =
            given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post("/auth/login/")
            .then()
                .statusCode(200)
                .extract()
                .response();

        response.prettyPrint();
    }

}