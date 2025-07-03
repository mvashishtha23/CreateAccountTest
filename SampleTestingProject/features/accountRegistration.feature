Feature: User Sign Up
  
  As a new user, I want to be able to create an account on the Website and verify it if it working with the same 
  credentials or not

  Scenario: Successful account creation
    Given I am on the create new customer account page
    When I fill in all required fields with valid information
    And I click the create an account button
    Then I should see a success message
    And I should be logged in

  Scenario: Account creation with existing email
    Given I am on the create new customer account page
    When I fill in the email field with an existing email address
    And I fill in the remaining required fields with valid information
    And I click the create an account button
    Then I should see an error message indicating the email is already registered
