@tag
Feature: TMS Listing - Demonstrate verification of Selling > Listing an Item (General
Classification) via the Web Interface.


  @tag1 
  Scenario Outline: Listing an Item (General Classification)
  	
  	Given Open the browser
  	And Navigate to TMS Login page
  	And The user login with a valid <email> and a valid <password>
    Then Verify the user is logged in to TMS successfully
  	When Listing an <itemName> with <startPrice> and uploading its image <fileName>
    
   Examples: 
      | email                       | password  |  itemName | startPrice | fileName       |
      | scottie.henderson@tsb.co.nz | T35tTr4d3 | Kids songs| 12.00		   | Test image.jpg |