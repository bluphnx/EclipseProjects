Feature: Search and place order   
Scenario: User should have same search experience in home and deals page  
Given User is on GreenKart home page
When user searched for string "Tom" 
And extract actual name from the product displayed
Then user searched same string "Tom" in offers page
And verify same product in home page exists in offers page