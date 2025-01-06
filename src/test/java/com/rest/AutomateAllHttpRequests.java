package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



//    ------------ ჰედერების დინამიურად გადაცემა ---------------
//HashMap<String, String> headers = new HashMap<String, String>();
//        headers.put("header", "value1");
//        headers.put("x-mock-match-request-headers", "header");
//        headers.put("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465");
//
//        given().
//        baseUri("https://c4d02499-47b8-4b86-8625-2961ccf82030.mock.pstmn.io").
//        headers(headers).





public class AutomateAllHttpRequests {
//    @BeforeClass
//    public void beforeClass() {
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
//                setBaseUri("https://api.postman.com").
//                addHeader("x-api-key", "PMAK-6776d09287e3f900011928f6-6ea05caccf7d38082ae295b37d5faee465").
//                setContentType(ContentType.JSON);
////                log(LogDetail.ALL)
//        RestAssured.requestSpecification = requestSpecBuilder.build();
//
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
//                expectStatusCode(200).
//                expectContentType(ContentType.JSON);
////                log(LogDetail.ALL)
//        RestAssured.responseSpecification = responseSpecBuilder.build();
//    }



    // Json - ის arrayList ად გატანის მაგალითი, mock სერვერის url გამოიყენება და ამიტო მაქვს ცალკე აღებული
    ResponseSpecification customResponseSpecification;
    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://c4d02499-47b8-4b86-8625-2961ccf82030.mock.pstmn.io").
                addHeader("x-mock-match-request-body", "true").
//                setConfig(config.encoderConfig(EncoderConfig.encoderConfig()
//                        .appendDefaultContentCharsetToContentTypeIfUndefined(false))).
//                setContentType(ContentType.JSON);
                setContentType("application/json;charset=utf-8");
        RestAssured.requestSpecification = requestSpecBuilder.build();


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON);
        customResponseSpecification = responseSpecBuilder.build();
    }


    @Test
    public void automateGet(){


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



// ფაილის წაიკითხვა რესურსების ფოლდერიდან და payload ში სტატიკურად გატანის გარეშე, File ობიექტად შემოტანა
//        File file = new File("src/main/resources/CreateWorkspacePayload.json");
//        given().
//                body(file).
//        when().
//                post("/workspaces").
//        then().
//                assertThat().
//                statusCode(200).
//                body("workspace.name", equalTo("MySecondWorkspace"),
//                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));



// body - ის გატანება HashMap - ით, გამოიყენება Jackson Databind - ის დეფენდენსი
//        HashMap<String, Object> mainObject = new HashMap<String, Object>();
//
//        HashMap<String, String> nestedObject = new HashMap<String, String>();
//        nestedObject.put("name", "MyThirdWorkspace");
//        nestedObject.put("type", "personal");
//        nestedObject.put("description", "Rest Assured Created this");
//
//        mainObject.put("workspace", nestedObject);
//
//        given().
//                body(mainObject).
//        when().
//                post("/workspaces").
//        then().
//                assertThat().
//                statusCode(200).
//                body("workspace.name", equalTo("MyThirdWorkspace"),
//                        "workspace.id", matchesPattern("^[a-z0-9-]{36}$"));

// Json - ის arrayList ად გატანის მაგალითი, mock სერვერის url გამოიყენება

//        HashMap<String, String> obj5001 = new HashMap<String, String>();
//        obj5001.put("id", "5001");
//        obj5001.put("type", "None");
//
//        HashMap<String, String> obj5002 = new HashMap<String, String>();
//        obj5002.put("id", "5002");
//        obj5002.put("type", "Glazed");
//
//        List<HashMap<String, String>> jsonList = new ArrayList<HashMap<String, String>>();
//        jsonList.add(obj5001);
//        jsonList.add(obj5002);
//
//        given().
//                body(jsonList).
//        when().
//                post("/post").
//        then().spec(customResponseSpecification).
//                assertThat().
//                body("msg", equalTo("Success"));


        // Complex json - ის გატანება
        List<Integer> idArrayList = new ArrayList<Integer>();
        idArrayList.add(5);
        idArrayList.add(9);

        HashMap<String, Object> batterHashmap2 = new HashMap<String, Object>();
        batterHashmap2.put("id", idArrayList);
        batterHashmap2.put("type", "Chocolate");

        HashMap<String, Object> batterHashmap1 = new HashMap<String, Object>();
        batterHashmap1.put("id", "1001");
        batterHashmap1.put("type", "Regular");

        List<HashMap<String, Object>> batterRrayList = new ArrayList<HashMap<String, Object>>();
        batterRrayList.add(batterHashmap1);
        batterRrayList.add(batterHashmap2);

        HashMap<String, List<HashMap<String, Object>>> battersHashMap = new HashMap<String, List<HashMap<String, Object>>>();
        battersHashMap.put("batter", batterRrayList);

        List<String> typeArrayList = new ArrayList<String>();
        typeArrayList.add("test1");
        typeArrayList.add("test2");

        HashMap<String, Object> toppingHashMap2 = new HashMap<String, Object>();
        toppingHashMap2.put("id", "5002");
        toppingHashMap2.put("type", typeArrayList);

        HashMap<String, Object> toppingHashMap1 = new HashMap<String, Object>();
        toppingHashMap1.put("id", "5001");
        toppingHashMap1.put("type", "None");

        List<HashMap<String, Object>> toppingArrayList = new ArrayList<HashMap<String, Object>>();
        toppingArrayList.add(toppingHashMap1);
        toppingArrayList.add(toppingHashMap2);


        HashMap<String, Object> mainHashMap = new HashMap<String, Object>();
        mainHashMap.put("id", "0001");
        mainHashMap.put("type", "donut");
        mainHashMap.put("name", "Cace");
        mainHashMap.put("ppu", 0.55);
        mainHashMap.put("batters", battersHashMap);
        mainHashMap.put("topping", toppingArrayList);

        given().
                body(mainHashMap).
        when().
                post("/postComplexJson").
        then().spec(customResponseSpecification).
                assertThat().
                body("msg", equalTo("Success"));




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
