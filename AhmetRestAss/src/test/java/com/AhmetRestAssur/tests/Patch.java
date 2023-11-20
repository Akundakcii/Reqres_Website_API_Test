package com.AhmetRestAssur.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Patch extends BaseTest{

    @Test
    public void patchUser(){

        //cagri yap
        JSONObject body = new JSONObject();
        body.put("name","Morpeheus");
        body.put("job","zion resident");
        Response response = given(spec)
                .contentType(ContentType.JSON)

                .body(body.toString())
                .patch("/api/users/2");
        response.prettyPrint();

        //assertion

        Assertions.assertEquals("Morpeheus",response.jsonPath().getJsonObject("name"));


    }
}
