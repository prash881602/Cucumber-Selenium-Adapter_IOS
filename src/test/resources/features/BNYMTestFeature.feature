Feature: Cucumber Test Scenarios

  Background: 
    Given A workbook named "BookTicket" and sheet named "Sheet2" is read

  Scenario Outline: TS_02
    When Browser is launched and navigate to specified url
    Then Book a bus ticket from "<location1>" to "<location2>"

    Examples: 
      | location1 | location2 |
      | from      | to        |
