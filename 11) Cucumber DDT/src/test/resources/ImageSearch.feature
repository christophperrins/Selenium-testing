Feature: Word classifier

    Scenario Outline: I type in different animal words 
    Given I am on the text Identifier Website
    # This parameter will create a single @When for all values 
    When I search for "<SearchTerm>"
    # This parameter will create a @When for each unique Identifier
    Then The <Identifier> Option should light up

    Examples:
    | SearchTerm | Identifier | 
    | Cat | Cat |
    | Kitten | Cat |
    | Lion | Cat |
    | Dog | Dog |
    | Doggo | Dog |
    | Wolf | Dog |
    | Giraffe | Other |
