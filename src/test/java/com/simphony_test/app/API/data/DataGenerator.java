package com.simphony_test.app.API.data;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenerator {

    public String generateRandomString(int size) {
        String chars = "-_qwertyuiopasdfghjklzxcvbnm";
        char[] str = new char[size];
        for (int i = 0; i < size; i++) {
            str[i] = chars.charAt((int) (Math.random() * chars.length()));
        }
        return String.valueOf(str);
    }

    public long generateRandomInteger(int size) {
        String numbers = "1234567890";
        char[] numberArray = new char[size];
        for (int i = 0; i < size; i++) {
            numberArray[i] = numbers.charAt((int) (Math.random() * numbers.length()));
        }
        return Long.parseLong(String.valueOf(numberArray));
    }

    public String generateDateOfBirth(long yearAgo) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/");
        long year = 2022 - yearAgo;
        return dateFormat.format(date) + year;
    }

    public String generateRandomUsername(int size) {
        String chars = "-_+qwertyuiopasdfghjklzxcvbnm";
        char[] str = new char[size];

        for (int i = 0; i < size; i++) {
            str[i] = chars.charAt((int) (Math.random() * chars.length()));
        }
        return String.valueOf(str);
    }
}
