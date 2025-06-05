Feature: Buzz Module Functionality

  Scenario: User should be able to post a message on the Buzz feed successfully

    Given User opens the application
    And User logs in with valid credentials
    When User navigates to the Buzz tab
    And Buzz Newsfeed should be displayed
    And User enters the Buzz message
    And User clicks on the Post button
    Then The message should be posted on the Buzz feed
