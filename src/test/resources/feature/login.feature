Feature: Account login
  @RunMe
  Scenario: Unsuccessful login
    Given user is in the login page
    When user adds invalid credentials
    And clicks login button
    Then user can see error message

  Scenario: Successful login
    Given user is in the login page
    When user adds valid credentials
    And clicks login button
    Then user is redirected to home page