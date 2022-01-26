package com.kar.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseStepDefinition {

    public static RequestSpecification httpRequest = null;
    public static Response response = null;
    public static int responseCode;

    public void startHTTPRequest(String url) throws NullPointerException {
        RestAssured.baseURI = url;
        RestAssured.useRelaxedHTTPSValidation();
        httpRequest = RestAssured.given().log().all();
    }

    public void initiateGetOperation(String endpoint) {
        response = httpRequest.get(endpoint);
    }

    public int getResponseCode() {
        responseCode = response.getStatusCode();
        System.out.println("Response Code : " + responseCode);
        return responseCode;
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }
}
