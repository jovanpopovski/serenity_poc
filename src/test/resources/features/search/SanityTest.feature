Feature: Send basic request's

  Scenario: Send request to register user
    When I send register request
    Then Data is retrieved

  Scenario: Send request for login user
    When I send login request
    Then Data is retrieved