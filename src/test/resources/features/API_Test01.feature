@apiTest

Feature: API Test

  Scenario: Check If Response is as expected

    Given User has the api base url
#    When  User adds the request payload
    When  User initiates GET operation by passing endpoint "api/users/2"
    Then  User should get 200 response code
    And   User gets the response body