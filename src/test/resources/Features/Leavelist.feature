Feature: View Leave List

  Scenario: Search for leaves in Leave List
    Given I am on the dashboard
    When I click on the Leave menu
    And I click on Leave List
    And I enter employee name "John Doe"
    And I select date range from "2024-05-01" to "2024-05-15"
    And I click on the Search button
    Then the leave records should be displayed
