@tag
Feature: TMS Search - Demonstrate verification of the Basic Search Functionality, within the
         Computers Category via the Web Interface.


  @tag1 
  Scenario Outline: Basic Search Functionality, within the Computers Category
  	
  	Given Open the browser
  	And Navigate to TMS Login page
  	And The user login with a valid <email> and a valid <password>
    Then Verify the user is logged in to TMS successfully
  	When Search by <searchKey> in computers category 
    
   Examples: 
      | searchKey  | email                       | password  |  
      | Dell       | scottie.henderson@tsb.co.nz | T35tTr4d3 |