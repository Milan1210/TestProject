package com.simphony_test.app.API;

import com.simphony_test.app.API.data.DataGenerator;
import com.simphony_test.app.API.data.DataProviderTst;
import com.simphony_test.app.API.data.TestData;
import com.simphony_test.app.Helper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends TestData {
    @Test(priority = 0,dataProvider = "RegisterUser",dataProviderClass = DataProviderTst.class)
    public void generateToken(String email, String password, String first_name, String last_name,String username, String dateOfBirth){
        Helper helper = new Helper();

        RestAssured.baseURI=BASE_URL;
        RestAssured.basePath=BASE_PATH;

        Map<String,String> body = new HashMap<>();

        body.put("email",email);
        body.put("password",password);
        body.put("firstName",first_name);
        body.put("lastName",last_name);
        body.put("username",username);
        body.put("dateOfBirth",dateOfBirth);

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

        helper.setPropery("EMAIL",email);
        helper.setPropery("PASSWORD",password);
        helper.setPropery("USERNAME",username);
    }

    @Test
    public void test(){
        System.out.println(new DataGenerator().generateRandomString(5));
        System.out.println(new DataGenerator().generateRandomString(5));
        System.out.println(new DataGenerator().generateRandomString(5));
        System.out.println(new DataGenerator().generateRandomString(5));
        System.out.println(new DataGenerator().generateRandomString(5));
    }
}
