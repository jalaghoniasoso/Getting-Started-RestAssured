package com.rest;

import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AutomateGet {
    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
                config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
                log().ifValidationFails().
        when().
                get("/workspaces").
        then().
                log().ifValidationFails().
                assertThat().
                statusCode(200);
    }
}