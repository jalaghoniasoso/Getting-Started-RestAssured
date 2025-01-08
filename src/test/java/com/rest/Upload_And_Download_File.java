package com.rest;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class Upload_And_Download_File {
    @Test
    public void upload_file_multipart_form_data(){
        String attributes = "{\"name\":\"temp.txt\", \"parent\":\"123456\"}}";
        given().
                baseUri("https://postman-echo.com").
                multiPart("file", new File("temp.txt")).
                multiPart("attributes", attributes, "application/json").
                log().all().
        when().
                post("/post").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    //Get - ში უნდა მიუთითო იმ ფაილის URL საიდანაც გინდა მისი გადმოწერა, დევთულსიდან უნდა წამოიღო
    @Test
    public void download_file_multipart_form_data() throws IOException {
        InputStream is = given().
                baseUri("https://raw.githubusercontent.com").
                log().all().
        when().
                get("/appium/appium/refs/heads/master/packages/appium/sample-code/apps/ApiDemos-debug.apk").
        then().
                log().all().
                extract().response().asInputStream();

        OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        os.write(bytes);
        os.close();;
    }
}
