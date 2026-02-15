Feature: Account login

  Scenario: Successful login
    Given user is in the login page
    When user adds valid credentials
    And clicks login button
    Then user is redirected to home page
  @RunMe
  Scenario Outline : Unsuccessful login
    Given user is in the login page
    When user adds invalid "<username>" and "<password>" credentials
    And clicks login button
    Then user can see "<error msg>" message

    Examples:
      |    username      | password    | error msg                            |
      |wrong@gmail.com   | wrong123    | Your email or password is incorrect! |
      |invalid@test      | 123456      | Your email or password is incorrect! |