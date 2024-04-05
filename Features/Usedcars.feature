#@regression @master
Feature: Validate the used cars details

  #@Regression @Smoke @Master
  Scenario: Validate the used cars details
    Given I am on the homepage
    When I hover over and select used cars
    And I select Chennai used cars
    Then The popular models should be displayed
