Feature: Register User
  @Register
  Scenario: User registration
    Given when user in register page
    When user adds valid name and email
    And user clicks on sign up button
    Then user should see the Additional Info section
    When user adds following account information details:
      | Title | Password | Day | Month    | Year |
      | Mr    | Admin@123|  2  | December | 1991 |
    And user select the newsletters and offers checkboxes
    And user fill in the address information:
      | FirstName | LastName | Company | Address         | Country       | State | City   | Zipcode | Mobile     |
      | John      | Doe      | ABC Ltd | 123 Main Street | United States | NY    | Albany | 12201   | 1234567890 |
    And user click the Create Account button
    Then user should see Account Created message