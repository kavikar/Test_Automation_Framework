@apiTest

Feature: Check If Response is as expected

  Scenario: Get Operation

    Given User has the api base url
#    When  User adds the request payload
    When  User initiates "GET" operation by passing endpoint "api/users/2"
    Then  User should get 200 response code
    And   User gets the response body

  Scenario: Post Operation

    Given User has the api base url
    When  User adds the request payload json file "test_payload.json"
    When  User initiates "POST" operation by passing endpoint "api/users"
    Then  User should get 201 response code
    And   User gets the response body

  Scenario Outline: Post Operation with Data Updating Parameters

    Given User has the api base url
    When  User passed "name,job" as "<Name>,<Job>" and adds the request payload json file "test_payload.json"
    When  User initiates "POST" operation by passing endpoint "api/users"
    Then  User should get 200 response code
    And   User gets the response body
    Examples:
      | Name   | Job    |
      | Naruto | Hokage |