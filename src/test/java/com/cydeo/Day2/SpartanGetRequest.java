package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {
String baseUrl = "http://3.90.70.155:8000";

    //  Given Accept type application/json
    //  When user send GET request to api/spartans end point
    //  Then status code must 200
    //  And response Content Type must be application/json
    //  And response body should include spartan result

    @Test void test1(){

        Response response = RestAssured.given().accept(ContentType.ANY.JSON)
                .when()

                .get(baseUrl+"/api/spartans");

        //Printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //Printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do API testing then ?
        //Verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //Verify content type is application/json
        Assertions.assertEquals(response.contentType(), "application/json");



    }




}
