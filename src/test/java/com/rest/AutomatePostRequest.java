package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class AutomatePostRequest {
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.getpostman.com").
                addHeader("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
                setContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
@Test
    public void automate_post_method(){
        String payload = "{\n" +
                "    \"workspace\": \n" +
                "        {\n" +
                "            \"name\": \"MyFirstWorkspace_001\",\n" +
                "            \"type\": \"personal\",\n" +
                "            \"description\": \"Rest Assured Created this\"\n" +
                "        }\n" +
                "}";
        given().
                body(payload).
                when().
                    post("/workspaces").
                then().
                assertThat().
                statusCode(200).
                body("workspace.name", equalTo("MyFirstWorkspace_001"),
                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));

    }

    @Test
    public void automate_post_method_file_object(){
        File file = new File("src/main/resources/CreateWorkspacePayload.json");
        given().
                body(file).
        when().
                post("/workspaces").
        then().
                assertThat().
                statusCode(200).
                body("workspace.name", equalTo("MyFirstWorkspace"),
                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));

    }

}
