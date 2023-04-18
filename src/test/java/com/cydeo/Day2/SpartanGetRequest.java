package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {
String baseUrl = "http://3.90.70.155:8000";

    //  Given Accept type application/json
    //  When user send GET request to api/spartans end point
    //  Then status code must be 200
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

    //  Given accept is type application/json
    //  When users send GET request to api/spartans/3
    //  Then status code should be 200
    //  And Content Type should be application/json
    //  And Json body should contain Fidole

    @DisplayName("Get one spartan/api/spartans/3 and verify")
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl + "/api/spartans/3");

        //Verify status code 200
        Assertions.assertEquals(response.statusCode(),200);

        //Verify content type
        Assertions.assertEquals(response.contentType(),"application/json");

        //Verify json body contains Fidole
        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }






}
