Feature: Login and logout functionality

  Scenario: Verification of Reset button and logout

    Given Open the Chrome and launch the application
    When Enter the Username and Password
    Then Reset the credential
    And User is successfully logged in
    When User clicks on the logout button
    Then User is redirected to the login page
