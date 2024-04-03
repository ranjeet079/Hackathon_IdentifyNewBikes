Feature: Validate the hover function over New bikes

  @smoke @regression @master
  Scenario: Validate the hover function over New bikes
    Given I open the website Zigwheels.com
    When I select upcoming bikes
    When clicking on upcoming bikes
    Then Display bike details
