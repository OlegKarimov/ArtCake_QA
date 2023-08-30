Feature: Login

  @validData
  Scenario: Login with valid data
    Given User launches browser
    When User opens ilCarro Home Page
    And  User clicks on Log in Link
    And User enters valid data
    And User clicks on Yalla button
    Then User veirfy Log in message
    And User quits browser

  @wrongPassword
  Scenario Outline: Login with valid email and wrong password
    Given User launches browser
    When User opens ilCarro Home Page
    And  User clicks on Log in Link
    And User enters valid email and wrong password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Yalla button
    Then User veirfies error
    And User quits browser
    Examples:
      | email | password |
      | mail@mail.com | 1234567Qwe |
      | mail@mail.com | 1234567000 |
      | mail@mail.com | abcdefQwe$ |
      | mail@mail.com | 123456789$ |