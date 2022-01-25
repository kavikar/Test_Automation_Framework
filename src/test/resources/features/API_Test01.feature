@apiTest

Feature: API Test
  Scenario: Check If Response is as expected

    Given User has the api base url
    When  User adds the request payload
    And   User initiates GET operation
    Then  User should get 200 response code