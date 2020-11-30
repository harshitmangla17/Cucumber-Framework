Feature: Login
 Scenario: Test the login scenario with valid credentials
 Given Open the chrome browser and open URL and maximize window
 When User enters the username and password
 And User click on the login button
 Then User should be able to login successfully
 
  Scenario: Test the login functionality with invalid credentials
  Given Open the chrome browser and open URL and maximize window
  When User enters the invalid username and password
  And User click the login button
  Then User should not be able to login successfully