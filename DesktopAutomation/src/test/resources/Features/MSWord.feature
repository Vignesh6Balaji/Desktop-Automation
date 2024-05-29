Feature: MSWord

  Scenario: Create A Blank Document and Add Data
    Given Open MsWord Application
    When Click on Blank Template
    Then Enter Data into Document as "Hello World I'm Back"