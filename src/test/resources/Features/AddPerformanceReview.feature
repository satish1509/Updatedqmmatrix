Feature: Add Performance Review

  Scenario: Manager adds a performance review for an employee
    Given I am on the dashboard
    When I click on the Performance tab
    And I click on Manage Reviews
    And I click on Add Review
    And I enter employee name "Oscar Martinez"
    And I select reviewer name "Michael Scott"
    And I set review period from "2024-01-01" to "2024-06-30"
    And I click on Save Review
    Then the performance review should be saved successfully
