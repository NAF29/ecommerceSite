Feature: Login Page Functionality

  Background: 
    Given user opens the browser

  #When user Enters url
  #Given I am on the login page
  @Sanity
  Scenario: Successful login with valid credentials
    When I enter valid username
    And I enter valid password
    And I click on the login button
    
@Sanity
  Scenario: Unsuccessful login with invalid username
    When I enter an invalid username
    And I enter a valid password
    And I click on the login button
    Then I should see an error message indicating invalid credentials

@Sanity
  Scenario: Unsuccessful login with invalid password
    When I enter a valid username
    And I enter an invalid password
    Then I should see an error message indicating invalid credentials
@regression
  Scenario: Unsuccessful login with empty field
    When I leave the username and password fields empty.....And
    Then I should see an error message indicating required fields

  Scenario: Forgot password link functionality
    When I click on the forgot password link
    Then I should be redirected to the password reset page

  Scenario: Remember me functionality
    And I have previously logged in with "Remember Me" option checked
    When I revisit the login page
    Then I should see my username pre-populated
    And I should be able to login without entering credentials again
