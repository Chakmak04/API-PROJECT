package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {

    //BeforeAll is an annotation equals to @BeforeClass in testNG
    //We use with static method name
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://3.90.70.155:1000/ords/hr";

    }

    @DisplayName("Get request to /regions")
    @Test
    public void test1(){

        Response response = RestAssured.get("/regions");

        //print status code
        System.out.println(response.statusCode());

    }

    /*
    Given accept type is application/json
    when user sends get request to /regions/2
    Then response status code must be 200
    and content type equals to application
    and response body contains Americas
     */

    @DisplayName("Get request to/regions/2")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)

                .when()

                         .get("/regions/2");

        //Verify status code
        assertEquals(200,response.statusCode());

        //Verify content type
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //Verify body contains Americas
        assertTrue(response.body().asString().contains("Americas"));





    }
}


