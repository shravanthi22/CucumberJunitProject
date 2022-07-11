
Feature: Validate Login
  @validlogin
  Scenario: User should login with valid credentials
   Given User should Open browser as "chrome"
   And User should Launch url
   When User enter Username "standard_user"
   And User enter Password "secret_sauce"
   And Click on Login button
   Then User should navigate to HomePage
    
  @invalidlogin
  Scenario Outline: user should not able to login with invalid credentials
   Given User should Open browser as "<browser>"
   And User should Launch url
   When User enter Username "<username>"
   And User enter Password "<pwd>"
   When Click on Login button
   Then User should get error message
   Examples:
   |browser|username|pwd|
   |chrome|test|test123|
   |chrome|abctest|abc123|