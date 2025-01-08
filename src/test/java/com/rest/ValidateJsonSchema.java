package com.rest;

import io.restassured.config.EncoderConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

//ეს არ მუშაობს,
//მაგრამ აქ დაწერილია იმის მაგლითი თუ როგორ უნდა დავავლიდიროთ json ფაილი
//უდემის კურსის Section_22
public class ValidateJsonSchema {
    @Test
    public void validateJsonSchema(){
        given().
                baseUri("https://postman-echo.com").
                log().all().
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("EchoGet.json"));
    }
}