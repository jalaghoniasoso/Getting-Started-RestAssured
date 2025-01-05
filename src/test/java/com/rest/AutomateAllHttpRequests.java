package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomateAllHttpRequests {
    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
                setContentType(ContentType.JSON);
//                log(LogDetail.ALL)
        RestAssured.requestSpecification = requestSpecBuilder.build();


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON);
//                log(LogDetail.ALL)
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }


    @Test
    public void automateGet(){
//              ----------------- Get ----------------------
//         ამით ხდება body - ის შემოწმება
//         given().
//                when().
//                get("/workspaces").
//        then().
//                assertThat().
//                statusCode(200).
//                body("workspaces.name", hasItems("MyFirstWorkspace", "Hashbank", "myWorckspase"));



//        აქ ხდება ცალკეული ელემენტის შემოწმება
//        String response = given().
//        when().
//                get("/workspaces").
//        then().
//                assertThat().
//                statusCode(200).
//                extract().response().asString();
//        System.out.println(JsonPath.from(response).getString("workspaces[0].name"));




//        აქ პირდაპირ ცალკეული ელემენტი მოგვაქვს
//        String name = given().
//        when().
//                get("/workspaces").
//        then().
//                assertThat().
//                statusCode(200).
//                extract().response().path("workspaces[0].name");
//        System.out.println(name);
//
//        ----------------- Post ----------------------
//    String payload = "{\n" +
//            "    \"workspace\": \n" +
//            "        {\n" +
//            "            \"name\": \"MyFirstWorkspace\",\n" +
//            "            \"type\": \"personal\",\n" +
//            "            \"description\": \"Rest Assured Created this\"\n" +
//            "        }\n" +
//            "}";
//    given().
//            body(payload).
//    when().
//            post("/workspaces").
//    then().
//            assertThat().
//            statusCode(200).
//            body("workspace.name", equalTo("MyFirstWorkspace"),
//                    "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));




//                ----------------- Put ----------------------
//        String workspaceId = "22a10221-c072-4c72-ad48-76be8cc23c87";
//        String payload = "{\n" +
//                "    \"workspace\": \n" +
//                "        {\n" +
//                "            \"name\": \"newNameFromRestAssured\",\n" +
//                "            \"type\": \"personal\",\n" +
//                "            \"description\": \"Rest Assured Created this\"\n" +
//                "        }\n" +
//                "}";
//        given().
//                body(payload).
//                pathParam("workspaceId", workspaceId).
//        when().
//                put("/workspaces/{workspaceId}").
//        then().
//                assertThat().
//                statusCode(200).
//                body("workspace.name", equalTo("newNameFromRestAssured"),
//                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"),
//                        "workspace.id", equalTo(workspaceId));




//                ----------------- Delete ----------------------
//        String workspaceId = "22a10221-c072-4c72-ad48-76be8cc23c87";
//        given().
//                pathParam("workspaceId", workspaceId).
//        when().
//                delete("/workspaces/{workspaceId}").
//        then().
//                assertThat().
//                statusCode(200).
//                body("workspace.id", matchesPattern("^[a-z0-9-]{36}$"),
//                        "workspace.id", equalTo(workspaceId));


    }
}
