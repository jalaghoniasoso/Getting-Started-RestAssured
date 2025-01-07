package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AutomateSingleElemetGetMethod {
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
                setContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();
    }
    @Test
    public void automate_single_get_element_with_response(){
        Response response =
        given().
        when().
                get("/workspaces").
                then().extract().response();
        JsonPath jsonPath = new JsonPath(response.asString());
        List<Map<String, String>> workspaces = jsonPath.getList("workspaces");
        Map<String, String> firstWorkspace = workspaces.get(0);
        System.out.println(firstWorkspace.get("name"));

    }
    @Test
    public void automate_single_get_element_with_string(){
        String response =
                given().
                        when().
                        get("/workspaces").
                then().extract().response().asString();
        System.out.println(JsonPath.from(response).getString("workspaces[0].name"));
    }
    @Test
    public void automate_single_get_element_with_string_directly(){
        String name =
                given().
                        when().
                        get("/workspaces").
                then().extract().response().path("workspaces[0].name");
        System.out.println(name);
    }
}