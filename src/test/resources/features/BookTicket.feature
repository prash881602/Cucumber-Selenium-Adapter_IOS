Feature: Book Ticket at RedBus

  Background: 
    Given A workbook named "BookTicket" and sheet named "Sheet1" is read

  @smoke
  Scenario Outline: TS_01
    When Browser is launched and navigate to specified url
    Then Book a bus ticket from "<location1>" to "<location2>"

    Examples: 
      | location1 | location2 |
      | from      | to        |
