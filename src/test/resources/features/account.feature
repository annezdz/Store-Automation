Feature: Create Account Testing

  Background: Opening browser and acessing My Account
      Given I initialize the browser with Chrome
      And navigate to "http://tutorialsninja.com/demo"
      And click on "My Account"


  Scenario: Accessing Register Account page successfully
    And click on "Register"
    Then I go to "Register Account" page
