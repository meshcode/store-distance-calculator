Feature: Calculate and point creation test

   Scenario: Calculate test - check if calculator is working properly
     Given Calculator module and Point module is OK
     When Create point using "Nam4e" 0.0 0.0
     And Create second point using "Name1" 2.0 0.0
     And Calculate distance "Nam4e" 0.0 0.0 "Name1" 2.0 0.0
     Then Distance equals 2.0


  Scenario: Calculate test - check if calculator is working properly!
    Given Calculator module and Point module is OK
    When Create point using "Name" 2.0 1.0
    And Create second point using "Name1" -5.0 7.0
    And Calculate distance "Name" 2.0 1.0 "Name1" -5.0 7.0
    Then Distance equals 9.21