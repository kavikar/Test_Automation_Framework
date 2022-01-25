package com.kar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import utilities.ConfigReader;

import java.util.Properties;

public class APIStepDefinition {

    ConfigReader configReader = new ConfigReader();
    Properties properties = configReader.readProperties();

    @Given("User has the api base url")
    public void userHasTheApiBaseUrl() {
        RestAssured.baseURI = properties.getProperty("apiBaseURL");
    }

    @Then("User should get {int} response code")
    public void userShouldGetResponseCode(int responseCode) {
    }

    @When("User adds the request payload")
    public void userAddsTheRequestPayload() {
    }

    @And("User initiates GET operation")
    public void userInitiatesGETOperation() {
        RestAssured.request(Method.GET);
    }
}
