@Parabank
Feature: Parabank

  @AdminLogin
  Scenario: Adminlogin
    Given the user launches the chrome
    When the user enters the username and password
    And Clicks on Login button
    Then the Account home page is displayed

  @OpenNewAccount
  Scenario: OpenNewAccount
    Given the user clicks on the Open New account Link
    When the user selects an option from the "What type of Account would you like to open?" dropdown list box
    And the user selects an option from the "A minimum of $100.00 must be deposited into this account at time of opening. Please choose an existing account to transfer funds into the new account" drop down list box
    And the user clicks on the Open New Account button
    Then the user is displayed with the "Account Opened!" page

  @TransferFund
  Scenario: TransferFund
    Given the user clicks on the Transfer Fund link
    When the user enters the amount in the amount field
    And selects the from account #
    And selects the To account #
    And the user clicks on the Transfer button
    Then the user will be displayed with the Transfer Complete! page

  @BillPay
  Scenario: BillPay
    Given the user clicks on the Bill Pay link
    When the user enters all the necessary details for bill pay
    And Selects the account from the "From AccounT Drop down list box
    And Clicks on the Send Payment Button
    Then the Bill Payment Complete page is displayed

  @FindTransaction
  Scenario: FindTransaction
    Given the user clicks on the Find Transcation link
    When the user enters the value in  any of the given options
    And the user clicks on the Find Transactions button
    Then the user is displayed with the Transactions Results Page

  @UpdateContactInfo
  Scenario: UpdateContactInfo
    Given the user is in the customer page
    When the user clicks on the Update Contact Info button
    And the user enters all the necessary details
    And user clicks on the Update Profile Button
    Then the user is displayed with the Profile Updated page

  @RequestLoan
  Scenario: RequestLoan
    Given the user clicks on the Request loan link
    When the user enters the loan amount
    And the user enters the Down Payment amount
    And the user selects the from account
    And the user clicks on the Apply now button
    Then the user is displayed with the Loan Request Processed page

  @AdminLogout
  Scenario: AdminLogout
    Given the user is in the customer page
    When the user clicks on the Logout button
    Then the user is logged out successfully
