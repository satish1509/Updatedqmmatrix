Feature: Logout from OrangeHRM

  Scenario: Logout from application
    Given I am on the dashboard
    When I click on the user profile
    And I click on Logout
    Then I should be redirected to the login page
