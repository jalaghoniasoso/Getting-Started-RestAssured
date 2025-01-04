package com.rest;

import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Mine {
    @org.testng.annotations.Test
    public void test() {

       given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
        when().
                get("/workspaces").
        then().
                statusCode(200).
                body("workspaces.name", hasItems("Hashbank", "myWorckspase"),
                        "workspaces.name", hasSize(2),
                        "workspaces.name", not(hasItems("test")),
                        "workspaces.visibility", contains("team", "personal"),
                        "workspaces[0]", hasKey("id"),
                        "workspaces[0]", hasValue("2ddd9b12-2c1c-44cf-9f57-7ba7b9eddcf5"));


    }
}