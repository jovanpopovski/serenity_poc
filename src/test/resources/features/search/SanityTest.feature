Feature: Send basic request's

  Scenario: Send request to req/res and validate response
    When I send login request
    Then Data is retrieved