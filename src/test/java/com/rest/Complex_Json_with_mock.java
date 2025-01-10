package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Complex_Json_with_mock {
    ResponseSpecification customResponseSpecification;
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://c4d02499-47b8-4b86-8625-2961ccf82030.mock.pstmn.io").
                addHeader("x-api-key", "").
                setContentType("application/json;charset=utf-8");
//                setConfig(config.encoderConfig(EncoderConfig.encoderConfig()
//                        .appendDefaultContentCharsetToContentTypeIfUndefined(false))).
//                setContentType(ContentType.JSON);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON);
        customResponseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void sen_complex_json(){
        List<Integer> idArrayLits = new ArrayList<>();
        idArrayLits.add(5);
        idArrayLits.add(9);

        HashMap<String, Object> batterHashmap1 = new HashMap<String, Object>();
        batterHashmap1.put("id", "1001");
        batterHashmap1.put("type", "Regular");

        HashMap<String, Object> batterHashmap2 = new HashMap<String, Object>();
        batterHashmap2.put("id", idArrayLits);
        batterHashmap2.put("type", "Chocolate");

        List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String, Object>>();
        batterArrayList.add(batterHashmap1);
        batterArrayList.add(batterHashmap2);

        HashMap<String, List<HashMap<String, Object>>> battersHashmap
                = new HashMap<String, List<HashMap<String, Object>>>();
        battersHashmap.put("batter", batterArrayList);

        List<String> typeArrayList = new ArrayList<String>();
        typeArrayList.add("test1");
        typeArrayList.add("test2");

        HashMap<String, Object> toppingHashmap1 = new HashMap<String, Object>();
        toppingHashmap1.put("id", "5001");
        toppingHashmap1.put("type", "None");

        HashMap<String, Object> toppingHashmap2 = new HashMap<String, Object>();
        toppingHashmap2.put("id", "5002");
        toppingHashmap2.put("type", typeArrayList);

        List<HashMap<String, Object>> toppingArrayList = new ArrayList<HashMap<String, Object>>();
        toppingArrayList.add(toppingHashmap1);
        toppingArrayList.add(toppingHashmap2);

        HashMap<String, Object> mainHashmap = new HashMap<String, Object>();
        mainHashmap.put("id", "0001");
        mainHashmap.put("type", "donut");
        mainHashmap.put("name", "Cake");
        mainHashmap.put("ppu", 0.55);
        mainHashmap.put("batters", battersHashmap);
        mainHashmap.put("topping", toppingArrayList);

        given().
                body(mainHashmap).
        when().
                post("/postComplexJson").
        then().
                spec(customResponseSpecification).
                assertThat().log().all().
                body("msg", equalTo("Success"));

    }
}
