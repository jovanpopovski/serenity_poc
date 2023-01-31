Feature: Send basic request's

  Scenario: Send request to register user
    When I send register request
    Then Status is 200 OK

  Scenario: Send request for login user
    When I send login request
    Then Status is 200 OK