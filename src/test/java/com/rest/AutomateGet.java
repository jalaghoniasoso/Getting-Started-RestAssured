package com.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomateGet {
    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("Hashbank", "myWorckspase"),
                        "workspaces.type", hasItems("team", "personal"),
                        "workspaces[0].name", is(equalTo("Hashbank")),
                        "workspaces.size()", equalTo(2));
    }
}