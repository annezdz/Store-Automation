Feature: Login Account

  Background: Opening browser and acessing My Account
    Given I initialize the browser with Chrome
    And navigate to "http://tutorialsninja.com/demo"
    And click on "My Account"

    Scenario: Login Successfully
      And click on "Login"
      And input a email already registered in "Login" page
      And click on "Button"
      Then the login status is "success"

    Scenario Outline: Forgotten Password
      And click on "Login"
      And click on "Forgotten"
      And input a email already registered in "Forgotten" page
      And click on "Continue"
      Then the message <message> is displayed

      Examples:
        | message                                        |
        |  An email with a confirmation link has been sent your email address. |





