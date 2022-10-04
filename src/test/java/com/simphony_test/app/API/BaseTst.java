package com.simphony_test.app.API;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTst {

    @BeforeMethod
    public void test(){
        System.out.println("This is before methods");
    }
}
