package com.rest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Test {
    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
        when().
                get("/workspaces").
        then().
                statusCode(200);
    }
}