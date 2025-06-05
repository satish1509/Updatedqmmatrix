Feature: Search Employee in Directory

  Scenario: Search employee by name and location
    Given I am on the dashboard
    When I click on the Directory tab
    And I enter employee name "Rachel Green"
    And I select location "New York Sales Office"
    And I click on Search
    Then matching employees should be displayed
