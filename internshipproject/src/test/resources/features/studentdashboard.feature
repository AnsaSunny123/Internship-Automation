Feature: Student Dashboard page

  Scenario: Verify the Back button
    Given The details page of Library Management System
    When Clicking on Back button
    Then The page moves to the Student Dashboard Page

  Scenario: Verify Proceed button
    Given The details page of Library Management System after ticking the declaration box
    When Clicking on Proceed button
    Then The page moves to Project Dashboard page