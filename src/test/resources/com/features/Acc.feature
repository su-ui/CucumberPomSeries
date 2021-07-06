Feature: Account pae feature

  Background: 
    Given User has already logged in to the application
      | username          | password |
      | ssvagle@gmail.com | Bang@123 |

  Scenario: Accounts page title
    Given user is on the accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given user is on the accounts page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And Accounts section count should be 5
