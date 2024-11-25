Feature: ICTAK Internship Portal Home Page Testing

  Scenario: Verify the home page loads successfully
    Given User Launch Chrome browser
    When User opens URL "https://internship-ictak.vercel.app/"
    Then The home page should load successfully
   
Scenario: Verify the page title
    Given User Launch Chrome browser
    When User opens URL "https://internship-ictak.vercel.app/"
    Then The title should display as "ICTAK Internship"
 

Scenario: Verify "Home" button functionality
    Given User Launch Chrome browser
    When User opens URL "https://internship-ictak.vercel.app/"
    And User clicks on the Home button
   
 Scenario: Verify "Login" button functionality
    Given User Launch Chrome browser
    When User opens URL "https://internship-ictak.vercel.app/"
    And User clicks on the Login button
    Then User should be navigated to the login page