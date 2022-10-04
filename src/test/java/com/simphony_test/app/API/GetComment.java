package com.simphony_test.app.API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetComment extends GenerateToken{

    @Test(priority = 3)
    public void getComment(){
        Response response =
                given()
                    .contentType(ContentType.JSON)
                    .header("Authorization",token)
                .when()
                    .get("/posts/338/comments/")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        response.prettyPrint();
    }
}
