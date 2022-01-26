package com.kar.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

public class BaseStepDefinition {

    public static RequestSpecification httpRequest = null;
    public static Response response = null;
    public static int responseCode;
    public static String responseBody;
    public Logger logger = Logger.getLogger(BaseStepDefinition.class);

    public void startHTTPRequest(String url) throws NullPointerException {
        RestAssured.baseURI = url;
        RestAssured.useRelaxedHTTPSValidation();
        httpRequest = RestAssured.given().log().all();
    }

    public void initiateGetOperation(String endpoint) {
        response = httpRequest.get(endpoint);
    }

    public void getResponseCode() {
        responseCode = response.getStatusCode();
        System.out.println("Response Code : " + responseCode);
    }

    public void getResponseBody() {
        responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body : " + responseBody);
    }
}
