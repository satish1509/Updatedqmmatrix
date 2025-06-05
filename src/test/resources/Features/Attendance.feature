Feature: Manage Attendance

  Scenario: Employee punches in and out
    Given I am on the dashboard
    When I click on the Attendance tab
    And I click on Punch In
    And I enter in note "Starting shift"
    And I click on Save Punch In
    And I click on Punch Out
    And I enter out note "End of shift"
    And I click on Save Punch Out
    Then attendance should be marked successfully
