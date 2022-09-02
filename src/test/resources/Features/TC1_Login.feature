@Login
Feature: Verify Adactin Login page Details

  Scenario Outline: Verifying Adactin hotel login with valid credentials
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify Welcome Page after login "Hello SudhakSay!"

    Examples: 
      | username  | password   |
      | SudhakSay | theriyathu |
@WithEnter
  Scenario Outline: Verifying Adactin Login with valid credentials with Enter Key
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>" with enter key
    Then User should verify Welcome Page after login "Hello SudhakSay!"

    Examples: 
      | username  | password   |
      | SudhakSay | theriyathu |
@LoginError
  Scenario Outline: Verify Adactin Login with Invalid Credentials
    Given User is on the adactin hotel login page
    When User should perform login "<username>","<password>"
    Then User should verify login error contains "Invalid Login details or Your Password might have expired. Click here to reset your password" after perform login with Invalid Credentials

    Examples: 
      | username  | password |
      | Kadhir001 | abc@321  |
