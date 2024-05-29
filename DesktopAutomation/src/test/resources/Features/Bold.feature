Feature: MSWord Bold

  Scenario: Create A Blank Document and Add Data 
    Given Open MsWord App
    When Click on Blank
    And Enter Data as "Hello World"
    And Make the datas Bold and Italic
    Then Close the Application