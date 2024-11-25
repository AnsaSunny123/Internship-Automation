Feature: User Login Functionality on ICTAK Internship Portal

  Scenario: Successful User Login
    Given User launches the Chrome browser
    When User navigates to "https://internship-ictak.vercel.app/"
    When User clicks on the "Login" button in the navbar
    And User enters valid credentials "fathima@gmail.com" and "123456"
    And User clicks the "Submit" button
    Then User should be successfully logged in and redirected to the student dashboard page
    
  Scenario: UnSuccessful User Login
    Given User launches the Chrome browser
    When User navigates to "https://internship-ictak.vercel.app/"
    When User clicks on the "Login" button in the navbar
    And User enters valid credentials "fathima@gmail.com" and "1234"
    And User clicks the "Submit" button
    
  Scenario: Verify  login with valid username and blank password
    Given User launches the Chrome browser
    When User navigates to "https://internship-ictak.vercel.app/"
    When User clicks on the "Login" button in the navbar
    And User enters valid credentials "fathima@gmail.com" and ""
    And User clicks the "Submit" button
   
 