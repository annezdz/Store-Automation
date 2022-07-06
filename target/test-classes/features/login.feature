Feature: Login Account

  Background: Opening browser and acessing My Account
    Given I initialize the browser with Chrome
    And navigate to "http://tutorialsninja.com/demo"
    And click on "My Account"

    Scenario: Login Successfully
      And click on "Login"
      And input a email already registered in "Login" page
#      And input a password
#      And click on "LoginButtom"
      Then I login successfully


