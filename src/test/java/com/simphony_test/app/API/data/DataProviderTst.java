package com.simphony_test.app.API.data;

import com.simphony_test.app.API.data.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataProviderTst extends TestData {

    @DataProvider(name="RegisterUser")
    public Object[][] register(){
        int email = 0;
        int pwd = 0;
        int fname = 0;
        int lname = 0;
        int username = 0;
        int date = 0;

        String[] emailArray = {NEW_EMAIL," ",generateRandomNumsAndLetters(9),EMAIL,generateRandomNumsAndLetters(160)+"@test.com", USERNAME+"!#$%^&*(|}@.com"};
        String[] passwordArray = {SET_PASSWORD," ","123",generateRandomString(10),""+generateRandomInteger(10)+"", "!@#$%^&*(|}@"};
        String[] firstNameArray = {FIRST_NAME," ",generateRandomString(100)};
        String[] lastNameArray = {LAST_NAME," ",generateRandomString(100)};
        String[] usernameArray = {SET_USERNAME," ",USERNAME,generateRandomNumsAndLetters(100)+"@test.com", USERNAME+"!@#$%^&*(|}@.com"};
        String[] dateOfBirthArray = {DATE_OF_BIRTH," ","12-10-1995",generateDateOfBirth(0)};

        ArrayList<String[]> array = new ArrayList<>();
        array.add(emailArray);
        array.add(passwordArray);
        array.add(firstNameArray);
        array.add(lastNameArray);
        array.add(usernameArray);
        array.add(dateOfBirthArray);

        int totalSize = emailArray.length+passwordArray.length+firstNameArray.length+lastNameArray.length+usernameArray.length+dateOfBirthArray.length;
        int startValue = 0;

        Object[][] dat = new Object[totalSize][6];
        while (startValue<totalSize){

            for (int i = 0; i<array.size();i++){
                for (int j = 0; j<array.get(i).length;j++){
                    switch (i){
                        case 0:
                            email=j;
                            break;
                        case 1:
                            pwd=j;
                            break;
                        case 2:
                            fname=j;
                            break;
                        case 3:
                            lname=j;
                            break;
                        case 4:
                            username=j;
                            break;
                        case 5:
                            date=j;
                            break;
                    }

                    System.out.println("Start value "+startValue);
                    dat[startValue][0]=array.get(0)[email];
                    dat[startValue][1]=array.get(1)[pwd];
                    dat[startValue][2]=array.get(2)[fname];
                    dat[startValue][3]=array.get(3)[lname];
                    dat[startValue][4]=array.get(4)[username];
                    dat[startValue][5]=array.get(5)[date];
                    startValue++;
                    emailArray[0]=new DataGenerator().generateRandomNumsAndLetters(9)+"@test.com";
                    usernameArray[0]=new DataGenerator().generateRandomNumsAndLetters(9);

                }
                System.out.println("This is email before reset "+email);
                    email = 0;
                System.out.println("This is email after reset "+email);
                    pwd = 0;
                    fname = 0;
                    lname = 0;
                    username = 0;
                    date = 0;
            }

            System.out.println("This is total size "+totalSize);
        }
        return dat;
    }

    @DataProvider(name="Login")
    public Object[][] datas(){
        Object[][] dat = new Object[7][2];
        for (int i =0;i<10;i++){

            dat[0][0]=EMAIL;
            dat[0][1]=PASSWORD;

            dat[1][0]=EMAIL;
            dat[1][1]="";

            dat[2][0]="";
            dat[2][1]=PASSWORD;

            dat[3][0]="";
            dat[3][1]="";

            dat[4][0]="invalid.email@tst.com";
            dat[4][1]=PASSWORD;

            dat[5][0]=EMAIL;
            dat[5][1]="InvalidPwd123";

            dat[6][0]="invalid.email@tst.com";
            dat[6][1]="InvalidPwd123";

        }
        return dat;

    }
}
