@sendmessage
Feature: Send message via Linkedin

  @sendmessage
  Scenario: Search for a person and validate the user is able to send message
    Given user launches the Linkedin url
    When user provides the login credentials
    And user searches for a name "Rakshith Bussari"
    And user is on "rakshithbussari" profile
    And user clicks on "Message" button
    And user provides "Hello Rakshith.This is the auto message from Ramya to Rakshith" in the message
    And user clicks on "Send" button
    And user clicks on "Close message box" button
    When user clicks on "Me" button
    And user clicks on "logout" button