Feature: Identity Management

@soapui    
Scenario Outline: Autheticate user and Get user profile
  Given I have a <username> and <password>
  When I call authetication service
  Then I should get Access Token 
  And I call user service to fetch the user profile
  
  Examples: Successfull Parameters 
    | username | password |
    | vinayak | secret |
    | john | secret |


