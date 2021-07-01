Feature: Search google

  @search
  Scenario: Google search
    Given I visit the url "https://www.google.com/"
    And I type "serenity handbook"