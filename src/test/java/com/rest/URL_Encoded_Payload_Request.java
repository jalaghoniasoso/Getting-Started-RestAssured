package com.rest;

import io.restassured.config.EncoderConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class URL_Encoded_Payload_Request {
    @Test
    public void form_url_encoded(){
        given().
                baseUri("https://postman-echo.com").
                config(config().encoderConfig(EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                formParam("key1", "value1").
                formParam("key 1", "value 1").
                log().all().
        when().
                post("/post").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
}