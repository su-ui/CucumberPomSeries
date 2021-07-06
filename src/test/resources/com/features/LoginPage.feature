Feature: Login Page Feature

  Scenario: Login Page Title
    Given User in on the login page
    When user gets the title of the page
    Then Page title should be "Login - My Store"

  Scenario: Forgot password link
    Given user is on the login page to check forgot password link
    Then forgot Your Password link should be displayed

  Scenario: Login with valid credentials
    Given User is on the login page
    When user enters username "ssvagle@gmail.com"
    And user enters password "Bang@123"
    And user clicks on login button
