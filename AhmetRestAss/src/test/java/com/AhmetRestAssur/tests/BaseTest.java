package com.AhmetRestAssur.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseTest {

    RequestSpecification spec;

    @BeforeEach
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new RequestLoggingFilter()))
                .build();
    }
    protected String olusturma(String name, String job) {
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("job", job);

        return body.toString();
    }

    protected Response createUser(){

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(olusturma("morpeheus","leader"))
                .post("/api/users");

        return response;
    }

    protected String register(String email, String passsword) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", passsword);

        return body.toString();
    }
    protected String registerTek(String email) {
        JSONObject body = new JSONObject();
        body.put("email", email);

        return body.toString();
    }
    protected Response Createregister(){

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(register("eve.holt@reqres.in","pistol")
                )
                .post("/api/register");


        return response;
    }
    protected Response UnSuccesfulCreateregister(){

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(registerTek("sydney@fife"))
                .post("/api/register");


        return response;
    }
    protected Response Login(){

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(register("eve.holt@reqres.in","cityslicka")
                )
                .post("/api/login");

        return response;
    }

    protected Response LoginUnSucces(){

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(registerTek("peter@klaven")
                )
                .post("/api/login");

        return response;
    }

}
