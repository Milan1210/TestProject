package com.simphony_test.app.API.data;

import com.simphony_test.app.Helper;

public class TestData extends DataGenerator {

    protected static final String BASE_URL = "https://randomlyapi.symphony.is";
    protected static final String BASE_PATH = "/api";


    protected static final String USERNAME = new Helper().getPropery("USERNAME");
    protected static final String PASSWORD = new Helper().getPropery("PASSWORD");
    protected static final String POST_ID = new Helper().getPropery("POST_ID");

    protected String EMAIL = generateRandomUsername(9) + "@test.com";
    protected String SET_PASSWORD = generateRandomString(5) + generateRandomInteger(4);
    protected String FIRST_NAME = generateRandomString(5);
    protected String LAST_NAME = generateRandomString(5);
    protected String SET_USERNAME = generateRandomUsername(4) + generateRandomInteger(3);
    protected String DATE_OF_BIRTH = generateDateOfBirth(generateRandomInteger(2)); // will generate from 0 to 99 year

}
