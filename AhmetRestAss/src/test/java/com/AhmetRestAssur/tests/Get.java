package com.AhmetRestAssur.tests;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get extends BaseTest{

    @Test
    public void getAll(){

        given(spec)
                .when()
                .get("/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void singleUser(){
        given(spec)
                .when()
                .get("api/users/7")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void SingleUserNotFound(){
        given(spec)
                .when()
                .get("api/users/23")
                .then()
                .log().all()
                .statusCode(404);
    }
    @Test
    public void ListResource(){
        given(spec)
                .when()
                .get("/api/unknown")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void SingleResource(){
        given(spec)
                .when()
                .get("/api/unknown/2")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void SingleResourceNotFound(){
        given(spec)
                .when()
                .get("/api/unknown/23")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void DelayedRespone(){
        given(spec)
                .when()
                .get("/api/users?delay=3")
                .then()
                .log().all()
                .statusCode(200);
    }


    //

    }

