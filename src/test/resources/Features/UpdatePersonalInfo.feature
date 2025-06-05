Feature: Update Personal Details

  Scenario: Edit and save personal information
    Given I am on the dashboard
    When I click on the My Info tab
    And I click on Personal Details
    And I edit First Name to "Michael"
    And I edit Last Name to "Scott"
    And I click on Save
    Then the changes should be updated successfully
