@tag1
Feature: TMS login feature - Demonstrate appropriate Test Cases for Customer Login Scenarios, and Login
    		 Page Validation via the Web Interface

  Background:
    Given Open the browser
    And Navigate to TMS Login page

  @tag1
  Scenario Outline: Verify if a user cannot login with a valid username and an invalid password.
  									Verify if a user cannot login with an invalid username and a valid password.
    
    When The user login with a valid <email> and an invalid <password>
    Then Validate the error message and the user is still in Login page
    Then Close the browser

    Examples: 
      | email                       | password  |
      | scottie.henderson@tsb.co.nz | T35tTr4d2 |
      | scottii.henderson@tsb.co.nz | T35tTr4d3 |
      
  @tag1
  Scenario Outline: Verify the login page for both, when the field is blank and Submit button is clicked.
     
    When The field is blank and Login button is clicked
    Then Verify field validation messages and the user is still in Login page
    Then Close the browser

    Examples: 
      | email                       | password  |
      | scottii.henderson@tsb.co.nz | T35tTr4d3 |
      
   @tag1
  Scenario Outline: Verify if a user will be able to login with a valid username and valid password.
     
    When The user login with a valid <email> and a valid <password>
    Then Verify the user is logged in to TMS successfully
    Then Close the browser

    Examples: 
      | email                       | password  |
      | scottie.henderson@tsb.co.nz | T35tTr4d3 |