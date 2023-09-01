package com.ArtCake.restAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI ="http://localhost:8080/";

    }
}
