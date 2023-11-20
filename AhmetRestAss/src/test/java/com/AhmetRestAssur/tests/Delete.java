package com.AhmetRestAssur.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Delete extends BaseTest {
    @Test
    public void deleteBookingTest(){

        // token
        //rezarvasyon
        //Delete Cagrsı
        Response response= given(spec)
                .contentType(ContentType.JSON)

                .when()
                .delete("/api/users/2");

        //Assertion
        response.then()
                .statusCode(204);



    }
}
