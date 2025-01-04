package com.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyClass {
    @Test
    public void validate_status_code(){
            given().
                    baseUri("https://api.postman.com").
                    header("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
            when().
                    get("/workspaces").
            then().
                    log().all().
                    assertThat().
                    statusCode(200);
    }
}
