package com.kar.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static utilities.GlobalRepo.scenario;

public class BaseStepDefinition {

    public static RequestSpecification request = null;
    public static Response response = null;
    public static int responseCode;
    public static String responseBody;
    public Logger logger = Logger.getLogger(BaseStepDefinition.class);

    public void startHTTPRequest(String url) throws NullPointerException {
        RestAssured.baseURI = url;
        RestAssured.useRelaxedHTTPSValidation();
        request = RestAssured.given().log().all();
    }

    public void log(String s) {
        scenario.log(s);
//        logger.info(s);
    }

    public void initiateGetOperation(String endpoint) {
        response = request.get(endpoint);
    }

    public void initiatePostOperation(String endpoint) {
        response = request.post(endpoint);
    }

    public void initiatePutOperation(String endpoint) {
        response = request.put(endpoint);
    }

    public void initiateDeleteOperation(String endpoint) {
        response = request.delete(endpoint);
    }

    public void addPayloadToRequest(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/request-payloads/" + fileName);
        request.header("Content-Type", "application/json");
        request.body(file);
    }

    public void addPayloadToRequest(String Keys, String Values, String fileName) throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/test/resources/request-payloads/" + fileName;
        String contents = new String(Files.readAllBytes(Paths.get(filepath)));
        JSONObject jsonObject = new JSONObject(contents);

        List<String> keysList = List.of(Keys.split(","));
        List<String> valuesList = List.of(Values.split(","));
        int n = keysList.size();
        for (int i = 0; i < n; i++) {
            jsonObject.put(keysList.get(i), valuesList.get(i));
        }

        request.header("Content-Type", "application/json");
        request.body(jsonObject.toString());
    }

    public void getResponseCode() {
        responseCode = response.getStatusCode();
        log("Response Code : " + responseCode);
    }

    public void getResponseBody() {
        responseBody = response.getBody().asPrettyString();
        log("Response Body : " + responseBody);
    }
}
