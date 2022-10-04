package com.simphony_test.app.API;

import com.simphony_test.app.API.data.TestData;
import com.simphony_test.app.API.obj.RegUserRes;
import com.simphony_test.app.Helper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends TestData {
    @Test(priority = 0)
    public void generateToken() {
        Helper helper = new Helper();

        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;

        String email = EMAIL;
        String password = SET_PASSWORD;

        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("firstName", FIRST_NAME);
        body.put("lastName", LAST_NAME);
        body.put("username", SET_USERNAME);
        body.put("dateOfBirth", DATE_OF_BIRTH);

        System.out.println(body);
        Response response = RestAssured
            .given()
                    .contentType(ContentType.JSON)
                    .body(body)
                .when()
                    .post("/auth/signup/")
                .then()
                    .statusCode(201)
                    .extract()
                    .response();

        response.prettyPrint();
        RegUserRes regUserRes = response.getBody().as(RegUserRes.class, ObjectMapperType.GSON);
        Assert.assertTrue(regUserRes.getSuccess().equals("Thanks for signing up."));
        helper.setPropery("USERNAME", email);
        helper.setPropery("PASSWORD", password);
    }
}
