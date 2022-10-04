package com.simphony_test.app.API;

import com.simphony_test.app.API.obj.AddPostBody;
import com.simphony_test.app.Helper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddComment extends GenerateToken {

    @Test(priority = 2)
    public void addPost() {
        AddPostBody addPostBody = new AddPostBody();
        addPostBody.setPost(POST_ID);
        addPostBody.setText("Test post " + generateRandomString(55));
        System.out.println("sss " + POST_ID);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .body(addPostBody)
                    .when()
                        .log()
                        .all()
                        .post("/post-comments/")
                    .then()
                        .extract()
                        .response();

        Assert.assertTrue(response.statusCode() < 310, "Post Id is not as expected");

        String postId = response.path("post");
        Helper helper = new Helper();

        helper.setPropery("COMMENT_ID", postId);
        response.prettyPrint();


    }
}