package com.rest;

import io.restassured.http.Header;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AutomateHeaders {
    @org.testng.annotations.Test
    public void multiple_headers() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "value1");
        headers.put("x-mock-match-request-headers", "header");
        headers.put("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465");

        given().
                baseUri("https://c4d02499-47b8-4b86-8625-2961ccf82030.mock.pstmn.io").
                headers(headers).
                log().all().
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);

    }
}