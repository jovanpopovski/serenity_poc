Feature: Send basic request's

  Scenario: Send request to req/res and validate response
    When I send request to service
    Then Data is retrieved