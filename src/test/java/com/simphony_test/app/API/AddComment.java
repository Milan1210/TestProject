package com.simphony_test.app.API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddComment extends GenerateToken {

    @Test(priority = 2)
    public void addPost(){

        JSONObject body = new JSONObject();
        body.put("text","Test post "+generateRandomString(55));
        body.put("post",POST_ID);

        Response response =
                    given()
                        .contentType(ContentType.JSON)
                        .header("Authorization",token)
                        .body(body)
                    .when()
                        .post("/post-comments/")
                    .then()
                        .extract()
                        .response();

        response.prettyPrint();


    }
}