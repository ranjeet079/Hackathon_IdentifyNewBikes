Feature: Google Sign In
  As a user
  I want to sign in using Google
  So that I can access my account

  #@Regression @Smoke @Master
  Scenario: Verify Login Page
    Given I am on homepage
    When I click on the Login/Signup button
    And I select the Google button
    Then The Login/SignUp card should be displayed

  #@Regression @Master
  Scenario: Verify Google Login
    Given I am on the Google Accounts sign in page
    When I enter my email
    And I click on the next button
    Then The error message should be captured if login fails
