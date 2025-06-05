Feature: Submit a Claim

  Scenario: Employee submits a travel claim
    Given I am on the dashboard
    When I click on the Claim tab
    And I click on Assign Claim
    And I select claim type "Travel"
    And I enter claim amount "1000"
    And I click on Submit
    Then the claim should be submitted for approval
