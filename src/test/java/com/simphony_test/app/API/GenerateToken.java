package com.simphony_test.app.API;

import static io.restassured.RestAssured.*;

import com.simphony_test.app.API.data.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;


public class GenerateToken extends TestData {
    protected String token;

    @BeforeClass
    public void Login(){
        baseURI=BASE_URL;
        basePath=BASE_PATH;

        Map<String,String> body = new HashMap<>();
        body.put("username",USERNAME);
        body.put("password",PASSWORD);

        Response response =
            given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .log()
                .all()
                .post("/auth/login/")
            .then()
                .statusCode(200)
                .extract()
                .response();

        response.prettyPrint();
        token = "token "+response.path("token");
        System.out.println("That is token "+token);
    }

}