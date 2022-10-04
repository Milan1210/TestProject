package com.simphony_test.app.API;

import com.simphony_test.app.Helper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AddPosts extends GenerateToken {

    @Test(priority = 1)
    public void addPost() {
        Helper helper = new Helper();

        JSONObject body = new JSONObject();
        body.put("text", "Test post " + generateRandomString(55));

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .body(body)
                    .when()
                        .log()
                        .all()
                        .post("/posts/")
                    .then()
                        .extract()
                        .response();

        response.prettyPrint();
        int id = response.path("id");
        helper.setPropery("POST_ID", String.valueOf(id));
    }
}