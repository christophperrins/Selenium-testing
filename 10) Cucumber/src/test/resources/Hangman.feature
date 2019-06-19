Feature: Hangman

Scenario: I enter a word into the input box
    Given User is on Hangman Page
    When User submits word
    Then Underscores displayed on the screen with the same length of word entered

Scenario: I guess the correct letter
	Given User is on Hangman Page
    And Word is entered into the game
    When User submits an correct letter
    Then letter is displayed on the screen

Scenario: I guess the incorrect letter
    Given User is on Hangman Page
    And Word is entered into the game
    When User submits an incorrect letter
    Then next hangman image gets shown

Scenario: I guess 5 incorrect letters
    Given User is on Hangman Page
    And Word is entered into the game
    When User submits an incorrect letter
    And User submits an incorrect letter
    And User submits an incorrect letter
    And User submits an incorrect letter
    And User submits an incorrect letter
    Then Message displayed Game over

Scenario: I guess all correct letters
    Given User is on Hangman Page
    And Word is entered into the game
    When I guess all letters
	Then Message displayed Win
