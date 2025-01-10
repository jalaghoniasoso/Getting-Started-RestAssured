package com.rest;

        import io.restassured.RestAssured;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.builder.ResponseSpecBuilder;
        import io.restassured.specification.ResponseSpecification;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

public class Assignment_Automate_Complex_JSON {
    ResponseSpecification customResponseSpecification;
    @BeforeClass
    public void beforeClass(){
        HashMap<String, String> headers = new HashMap<String, String>();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://c4d02499-47b8-4b86-8625-2961ccf82030.mock.pstmn.io").
                addHeader("x-api-key", "").
                setContentType("application/json;charset=utf-8");
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectContentType("application/json;charset=utf-8").
                expectStatusCode(200);
        customResponseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void assignment(){
        List<Integer> firstRgbaArray = new ArrayList<Integer>();
        firstRgbaArray.add(255);
        firstRgbaArray.add(255);
        firstRgbaArray.add(255);
        firstRgbaArray.add(1);

        HashMap<String, Object> firstCode = new HashMap<>();
        firstCode.put("rgba", firstRgbaArray);
        firstCode.put("hex", "#000");

        HashMap<String, Object> firstPart = new HashMap<String, Object>();
        firstPart.put("color", "black");
        firstPart.put("category", "hue");
        firstPart.put("type", "primary");
        firstPart.put("code", firstCode);

        List<Integer> secondRgbaArray = new ArrayList<Integer>();
        secondRgbaArray.add(0);
        secondRgbaArray.add(0);
        secondRgbaArray.add(0);
        secondRgbaArray.add(1);

        HashMap<String, Object> secondCode = new HashMap<>();
        secondCode.put("rgba", secondRgbaArray);
        secondCode.put("hex", "#FFF");

        HashMap<String, Object> secondPart = new HashMap<String, Object>();
        secondPart.put("color", "white");
        secondPart.put("category", "value");
        secondPart.put("code", secondCode);

        List<Object> mainPart = new ArrayList<Object>();
        mainPart.add(firstPart);
        mainPart.add(secondPart);

        HashMap<String,Object> mainJson = new HashMap<String,Object>();
        mainJson.put("colors", mainPart);

        given().
                body(mainJson).
                log().all().
                when().
                post("/postassignment").
                then().spec(customResponseSpecification).
                assertThat().log().all().
                body("msg", equalTo("success task"));

    }
}
