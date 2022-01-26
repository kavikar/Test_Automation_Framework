package com.kar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

import static utilities.GlobalRepo.properties;

public class APIStepDefinition extends BaseStepDefinition {

    @Given("User has the api base url")
    public void userHasTheApiBaseUrl() {
        startHTTPRequest(properties.getProperty("apiBaseURL"));
    }

    @And("User initiates {string} operation by passing endpoint {string}")
    public void userInitiatesGETOperationByPassingEndpoint(String method, String endpoint) {
        if(method.equalsIgnoreCase("GET"))
            initiateGetOperation(endpoint);
        else if(method.equalsIgnoreCase("POST"))
            initiatePostOperation(endpoint);
        else if(method.equalsIgnoreCase("PUT"))
            initiatePutOperation(endpoint);
        else if(method.equalsIgnoreCase("DELETE"))
            initiateDeleteOperation(endpoint);
    }

    @Then("User should get {int} response code")
    public void userShouldGetResponseCode(int expectedCode) {
        getResponseCode();
        Assert.assertEquals(responseCode, expectedCode);
    }

    @And("User gets the response body")
    public void userGetsTheResponseBody() {
        getResponseBody();
    }

    @When("User adds the request payload json file {string}")
    public void userAddsTheRequestPayloadJsonFile(String fileName) {
        addPayloadToRequest(fileName);
    }

    @When("User passed {string} as {string} and adds the request payload json file {string}")
    public void userPassedAsAndAddsTheRequestPayloadJsonFile(String Keys, String Values, String fileName) throws IOException {
        addPayloadToRequest(Keys,Values,fileName);
    }
}
