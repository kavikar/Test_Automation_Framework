package com.kar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static utilities.GlobalRepo.properties;

public class APIStepDefinition extends BaseStepDefinition {

    @Given("User has the api base url")
    public void userHasTheApiBaseUrl() {
        startHTTPRequest(properties.getProperty("apiBaseURL"));
    }

    @And("User initiates GET operation by passing endpoint {string}")
    public void userInitiatesGETOperationByPassingEndpoint(String endpoint) {
        initiateGetOperation(endpoint);
    }

    @Then("User should get {int} response code")
    public void userShouldGetResponseCode(int expectedCode) {
        Assert.assertEquals(getResponseCode(),expectedCode);
    }

    @When("User adds the request payload")
    public void userAddsTheRequestPayload() {
    }

    @And("User gets the response body")
    public void userGetsTheResponseBody() {
        System.out.println(getResponseBody());
    }
}
