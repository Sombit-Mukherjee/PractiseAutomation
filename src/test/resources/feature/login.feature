Feature: Account login
  Scenario: Successful login
    Given user is in the login page
    When user adds valid credentials
    And clicks login button
    Then user is redirected to home page