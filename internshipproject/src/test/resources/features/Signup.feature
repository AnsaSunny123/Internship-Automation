

Feature: ICTAK Internship Portal Signup Page Testing

  Scenario: Verify the signup page loads successfully
    
    When User opens URL for signup "https://internship-ictak.vercel.app/"
    And User clicks on the Login button for signup
    And User clicks on the New User Register link
    Then The signup page should load successfully
    
     Scenario: Verify the student signup functionality with valid details
    
    When User opens URL for signup "https://internship-ictak.vercel.app/"
    And User clicks on the Login button for signup
    And User clicks on the New User Register link
    And User enters name "Anu", email "anu@gmail.com", password "mypassword123", phone number "9898989898", and batch name "Batch 1"
    And User agrees to the terms and conditions
    And User clicks on the Continue button
    Then User should be successfully signed up and redirected to the login page
    
    
    Scenario: User tries to sign up with invalid email
    When User opens URL for signup "https://internship-ictak.vercel.app/"
    And User clicks on the Login button for signup
    And User clicks on the New User Register link
    When User enters name "anu", email "invalid-email", password "Password123", phone number "9876543210", and batch name "Batch 1"
    And User agrees to the terms and conditions
    And User clicks on the Continue button
    
     Scenario: Verify phone number validation
    When User opens URL for signup "https://internship-ictak.vercel.app/"
    And User clicks on the Login button for signup
    And User clicks on the New User Register link
    When User enters name "anu", email "athira@gmail.com", password "123456", phone number "ABCD", and batch name "Batch 1"
    And User agrees to the terms and conditions
    And User clicks on the Continue button
    
   