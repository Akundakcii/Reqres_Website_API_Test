package com.AhmetRestAssur.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Put extends BaseTest {

    @Test
    public void updateUser() {
        Response response = given(spec)
                .contentType(ContentType.JSON)

                .body(olusturma("morpeheus", "zion resident"))// olusturdgumuz body cagırma //GÜNCELLEME
                .put("/api/users/2");
        response.prettyPrint();


    //Assertions
    String name = response.jsonPath().getJsonObject("name");
        String job = response.jsonPath().getJsonObject("job");


        Assertions.assertEquals("morpeheus", name);

        Assertions.assertEquals("zion resident", job);

}


    }
