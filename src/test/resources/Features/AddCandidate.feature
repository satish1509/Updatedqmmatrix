Feature: Add New Candidate

  Scenario: Add a candidate in Recruitment
    Given I am on the dashboard
    When I click on the Recruitment menu
    And I click on Add Candidate
    And I enter candidate name "Alice Smith"
    And I enter email "alice@example.com"
    And I upload resume
    And I click on Save
    Then the candidate should be added successfully
