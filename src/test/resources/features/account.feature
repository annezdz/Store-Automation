Feature: Create Account Testing

  Background: Opening browser and acessing My Account
      Given I initialize the browser with Chrome
      And navigate to "http://tutorialsninja.com/demo"
      And click on "My Account"


  Scenario: Accessing Register Account page successfully
    And click on "Register"
    Then I go to "Register Account" webpage

    Scenario: Creating new user
      And click on "Register"
      And I go to "Register Account" webpage
      When I set information to create a user
      Then a new user is created


  Scenario Outline: Validating user already registered message
    And click on "Register"
    And I go to "Register Account" webpage
    When I set information to create a user
    And input a email already registered
    Then the message <message> is displayed

    Examples:
      | message                                        |
      | Warning: E-Mail Address is already registered! |

