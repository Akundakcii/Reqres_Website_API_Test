package com.AhmetRestAssur.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class Post extends BaseTest{

    @Test
    public void createBookingTests() {

        Response response = createUser();


    }

    @Test
    protected void registerCreate() {
        Response response = Createregister();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    protected void UnSucceslregisterCreate() {
        Response response = UnSuccesfulCreateregister();
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    protected void login() {
        Response response = Login();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    protected void loginUnSuccesful() {
        Response response = LoginUnSucces();
        response.then().statusCode(200);
        response.prettyPrint();
    }







}
