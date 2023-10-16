package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.En;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.lang.model.util.ElementScanner6;
import java.sql.Driver;

@QAFTestStepProvider

//Login Test case
public class ParabankStepsDefs {
    QAFExtendedWebDriver Para = new WebDriverTestBase().getDriver();

    @Given("^the user launches the chrome$")
    public void the_user_launches_the_chrome() throws Throwable {
        new WebDriverTestBase().getDriver().get("http://192.168.0.182:8080/parabank/index.htm");
//        throw new PendingException();
    }


    @When("^the user enters the username and password$")
    public void the_user_enters_the_username_and_password() throws Throwable {
        QAFExtendedWebElement userName = new QAFExtendedWebElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("john");
        QAFExtendedWebElement passWord = new QAFExtendedWebElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("demo");
//        throw new PendingException();
    }

    @When("^Clicks on Login button$")
    public void clicks_on_Login_button() throws Throwable {
        QAFExtendedWebElement login = new QAFExtendedWebElement(By.cssSelector("input[value='Log In']"));
        login.click();
    }

    @Then("^the Account home page is displayed$")
    public void the_Account_home_page_is_displayed() throws Throwable {
        QAFExtendedWebElement accountOverview = new QAFExtendedWebElement(By.xpath("//h1[normalize-space()='Accounts Overview']"));
        Thread.sleep(2000);
        String AOTitle = accountOverview.getText();
        if (AOTitle.contains("Accounts Overview")) {
            System.out.println("AccountS Overview  Success");
        } else {
            System.out.println("AccountS Overview Failure");
            Assert.fail("AccountS Overview Failure");
        }
        Thread.sleep(2000);
    }


    // Open New Account
    @Given("^the user clicks on the Open New account Link$")
    public void the_user_clicks_on_the_Open_New_account_Link() throws Throwable {
        QAFExtendedWebElement OpenNewAccount = new QAFExtendedWebElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
        OpenNewAccount.click();
        String ONATitle = OpenNewAccount.getText();
        if (ONATitle.contains("Open New Account")) {
            System.out.println("Open New Account Success");
        } else {
            System.out.println("Open New Account Failure");
            Assert.fail("Open New Account Failure");
        }
//        throw new PendingException();
    }

    @When("^the user selects an option from the \"([^\"]*)\" dropdown list box$")
    public void the_user_selects_an_option_from_the_dropdown_list_box(String arg1) throws Throwable {
        QAFExtendedWebElement AccountType = new QAFExtendedWebElement(By.xpath("//*[@id=\"type\"]"));
        Select dropdown = new Select(AccountType);
        dropdown.selectByVisibleText("CHECKING");
//        throw new PendingException();
    }

    @When("^the user selects an option from the \"([^\"]*)\" drop down list box$")
    public void the_user_selects_an_option_from_the_drop_down_list_box(String arg1) throws Throwable {
        QAFExtendedWebElement AccountNumber = new QAFExtendedWebElement(By.xpath("//*[@id=\"fromAccountId\"]"));
        Select dropdown = new Select(AccountNumber);
        dropdown.selectByIndex(5);
//        throw new PendingException();
    }

    @When("^the user clicks on the Open New Account button$")
    public void the_user_clicks_on_the_Open_New_Account_button() throws Throwable {
        QAFExtendedWebElement OpenAccountButton = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input"));
        OpenAccountButton.click();
//        throw new PendingException();
    }

    @Then("^the user is displayed with the \"([^\"]*)\" page$")
    public void the_user_is_displayed_with_the_page(String arg1) throws Throwable {
        QAFExtendedWebElement AccountOpened = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        Thread.sleep(2000);
        String AOTitle = AccountOpened.getText();
        if (AOTitle.contains("Account Opened!")) {
            System.out.println("Account Opened Success");
        } else {
            System.out.println("Account Opened Failure");
            Assert.fail("Account Opened Failure");
        }
        QAFExtendedWebElement Congratulations = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]"));
        String CTitle = Congratulations.getText();
        if (CTitle.contains("Congratulations, your account is now open.")) {
            System.out.println("Congratulations Success");
        } else {
            System.out.println("Congratulations failure");
            Assert.fail("Congratulations failure");
        }
        QAFExtendedWebElement NewNumber = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[2]/b"));
        String NNTitle = NewNumber.getText();
        if (NNTitle.contains("Your new account number:")) {
            System.out.println("New Number Success");
        } else {
            System.out.println("New Number failure");
            Assert.fail("New Number failure");
        }
        Thread.sleep(2000);
    }
// TRansfer fund

    @Given("^the user clicks on the Transfer Fund link$")
    public void the_user_clicks_on_the_Transfer_Fund_link() throws Throwable {
        QAFExtendedWebElement TransferFundslink = new QAFExtendedWebElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a"));
        TransferFundslink.click();
        QAFExtendedWebElement TransferFundTitle = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        String TFTitle = TransferFundTitle.getText();
        if (TFTitle.contains("Transfer Funds")) {
            System.out.println("Transfer Fund Success");

        } else {
            System.out.println("Transfer Fund Failure");
            Assert.fail("Transfer Fund Failure");
        }
//        throw new PendingException();
    }

    @When("^the user enters the amount in the amount field$")
    public void the_user_enters_the_amount_in_the_amount_field() throws Throwable {
        QAFExtendedWebElement Amount = new QAFExtendedWebElement(By.xpath("//*[@id=\"amount\"]"));
        Amount.sendKeys("152");
//        throw new PendingException();
    }

    @When("^selects the from account #$")
    public void selects_the_from_account() throws Throwable {
        QAFExtendedWebElement FromAccount = new QAFExtendedWebElement(By.xpath("//*[@id=\"fromAccountId\"]"));
        Select dropdown1 = new Select(FromAccount);
        dropdown1.selectByIndex(5);
//        throw new PendingException();
    }

    @When("^selects the To account #$")
    public void selects_the_To_account() throws Throwable {
        QAFExtendedWebElement ToAccount = new QAFExtendedWebElement(By.xpath("//*[@id=\"toAccountId\"]"));
        Select dropdown2 = new Select(ToAccount);
        dropdown2.selectByIndex(5);
//        throw new PendingException();
    }

    @When("^the user clicks on the Transfer button$")
    public void the_user_clicks_on_the_Transfer_button() throws Throwable {
        QAFExtendedWebElement TransferButton = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input"));
        TransferButton.click();
//        throw new PendingException();
    }

    @Then("^the user will be displayed with the Transfer Complete! page$")
    public void the_user_will_be_displayed_with_the_Transfer_Complete_page() throws Throwable {
        QAFExtendedWebElement TransferComplete = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        Thread.sleep(2000);
        String TCTitle = TransferComplete.getText();
        if (TCTitle.contains("Transfer Complete!")) {
            System.out.println("Transfer Complete Success");
        } else {
            System.out.println("Transfer Complete Failure");
            Assert.fail("Transfer Complete Failure");
        }

        QAFExtendedWebElement Confirmation = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]"));
        String ConfTitle = Confirmation.getText();
        if (
                ConfTitle.contains("has been transferred from account ")) {
            System.out.println("Confirmation Success");
        } else {
            System.out.println("Confirmation Failure");
        }

        QAFExtendedWebElement SeeActivity = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[2]"));
        String SeeActTitle = SeeActivity.getText();
        if (
                SeeActTitle.contains("See Account Activity for more details.")) {
            System.out.println("See Activity1 Success");
        } else {
            System.out.println("See Activity1 Failure");
            Assert.fail("See Activity1 Failure");
        } //        throw new PendingException();
    }

// Bill Pay

    @Given("^the user clicks on the Bill Pay link$")
    public void the_user_clicks_on_the_Bill_Pay_link() throws Throwable {
        QAFExtendedWebElement BillPayLink = new QAFExtendedWebElement(By.linkText("Bill Pay"));
        BillPayLink.click();
        QAFExtendedWebElement BillPayService = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1"));
        String BPTitle = BillPayService.getText();
        if (BPTitle.contains("Bill Payment Service")) {
            System.out.println("Bill Payment Page Success");
        } else {
            System.out.println("Bill Payment Page Failure");
            Assert.fail("Bill Payment Page Failure");
        }

        QAFExtendedWebElement EnterPayeeInfo = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/p"));
        String EPITitle = EnterPayeeInfo.getText();
        if (
                EPITitle.contains("Enter payee information")
        ) {
            System.out.println("Enter Payee Information Success");
        } else {
            System.out.println("Enter Payee Information Failure");
            Assert.fail("Enter Payee Information Failure");
        }

//        throw new PendingException();
    }

    @When("^the user enters all the necessary details for bill pay$")
    public void the_user_enters_all_the_necessary_details_for_bill_pay() throws Throwable {
        Thread.sleep(2000);
        QAFExtendedWebElement PayeeName = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input"));
        PayeeName.sendKeys("Rogers");
        QAFExtendedWebElement Address = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input"));
        Address.sendKeys("1234 brichmont road");
        QAFExtendedWebElement City = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input"));
        City.sendKeys("Scarborough");
        QAFExtendedWebElement State = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input"));
        State.sendKeys("Ontario");
        QAFExtendedWebElement ZipCode = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[5]/td[2]/input"));
        ZipCode.sendKeys("L1R 0C8");

        try {
            QAFExtendedWebElement Phone = new QAFExtendedWebElement(By.name("payee.phoneNumber"));
            Phone.sendKeys("1234567890");

        } catch (Exception e) {
            System.out.println("Unable to enter phone number:" + e);
        }

        QAFExtendedWebElement Accountno = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[8]/td[2]/input"));
        Accountno.sendKeys("123456");
        QAFExtendedWebElement VerifyAccountNo = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[2]/input"));
        VerifyAccountNo.sendKeys("123456");
        QAFExtendedWebElement Amount = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[11]/td[2]/input"));
        Amount.sendKeys("152");

    }

    @When("^Selects the account from the \"From AccounT Drop down list box$")
    public void selects_the_account_from_the_From_AccounT_Drop_down_list_box() throws Throwable {
        QAFExtendedWebElement FromAccount1 = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[13]/td[2]/select"));
        Select Dropdown3 = new Select(FromAccount1);
        Dropdown3.selectByIndex(5);

    }

    @When("^Clicks on the Send Payment Button$")
    public void clicks_on_the_Send_Payment_Button() throws Throwable {
        QAFExtendedWebElement SendPaymentButton = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input"));
        SendPaymentButton.click();
    }

    @Then("^the Bill Payment Complete page is displayed$")
    public void the_Bill_Payment_Complete_page_is_displayed() throws Throwable {
        QAFExtendedWebElement BillPaymentComplete = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/h1"));
        String BPCTitle = BillPaymentComplete.getText();
        if (
                BPCTitle.contains("Bill Payment Complete")
        ) {
            System.out.println("Bill Payment Complete Success");
        } else {
            System.out.println("Bill Payment Complete Failure");
            Assert.fail("Bill Payment Complete Failure");
        }

        QAFExtendedWebElement BillPaymentSuccessful = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/p[1]"));
        String BPSTitle = BillPaymentSuccessful.getText();
        if (
                BPSTitle.contains("was successful.")
        ) {
            System.out.println("Bill Payment Amount Success");
        } else {
            System.out.println("Bill Payment Amount Failure");
            Assert.fail("Bill Payment Amount Failure");
        }


        QAFExtendedWebElement SeeActivity1 = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/p[2]"));
        String SeeActTitle = SeeActivity1.getText();
        if (
                SeeActTitle.contains("See Account Activity for more details.")) {
            System.out.println("See Activity2 Success");
        } else {
            System.out.println("See Activity2 Failure");
            Assert.fail("See Activity2 Failure");
        }

    }

    // Find Transcations page

    @Given("^the user clicks on the Find Transcation link$")
    public void the_user_clicks_on_the_Find_Transcation_link() throws Throwable {
        QAFExtendedWebElement FindTransactionLink = new QAFExtendedWebElement(By.linkText("Find Transactions"));
        FindTransactionLink.click();
        QAFExtendedWebElement FindTransactionTitle = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        String FTTitle = FindTransactionTitle.getText();
        if (
                FTTitle.contains("Find Transactions")
        ) {
            System.out.println("Find Transaction Page Success");
        } else {
            System.out.println("Find Transaction Ppage failure");
            Assert.fail("Find Transaction Ppage failure");
        }
//        throw new PendingException();
    }

    @When("^the user enters the value in  any of the given options$")
    public void the_user_enters_the_value_in_any_of_the_given_options() throws Throwable {
        QAFExtendedWebElement SelectAnAccount = new QAFExtendedWebElement(By.xpath("//*[@id=\"accountId\"]"));
        Select Dropdown4 = new Select(SelectAnAccount);
        Dropdown4.selectByIndex(5);

        QAFExtendedWebElement FindByAmount = new QAFExtendedWebElement(By.xpath("//*[@id=\"criteria.amount\"]"));
        FindByAmount.sendKeys("152");
//        throw new PendingException();
    }

    @When("^the user clicks on the Find Transactions button$")
    public void the_user_clicks_on_the_Find_Transactions_button() throws Throwable {
        QAFExtendedWebElement FindTransactionButton = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[9]/button"));
        FindTransactionButton.click();
        Thread.sleep(2000);
//        throw new PendingException();
    }

    @Then("^the user is displayed with the Transactions Results Page$")
    public void the_user_is_displayed_with_the_Transactions_Results_Page() throws Throwable {
        QAFExtendedWebElement TransactionResults = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        String TRTitle = TransactionResults.getText();
        if (
                TRTitle.contains("Transaction Results")
        )
            System.out.println("Transaction Results Success");
        else {
            System.out.println("Transaction Results Failure");
            Assert.fail("Transaction Results Failure");
        }
        Thread.sleep(1000);


        QAFExtendedWebElement TRDate = new QAFExtendedWebElement(By.xpath("//*[@id=\"transactionTable\"]/thead/tr/th[1]"));
        String TRDTitle = TRDate.getText();
        if (TRDTitle.contains("Date")) {
            System.out.println("Date Success");

        } else {
            System.out.println("Date Failure");
            Assert.fail("Date Failure");
        }

        QAFExtendedWebElement TRTranscation = new QAFExtendedWebElement(By.xpath("//*[@id=\"transactionTable\"]/thead/tr/th[2]"));
        String TRTTitle = TRTranscation.getText();
        if (TRTTitle.contains("Transaction")) {
            System.out.println("Transcation Success");

        } else {
            System.out.println("Transcation Failure");
            Assert.fail("Transcation Failure");
        }

        QAFExtendedWebElement TRDebit = new QAFExtendedWebElement(By.xpath("//*[@id=\"transactionTable\"]/thead/tr/th[3]"));
        String TRDebitTitle = TRDebit.getText();
        if (TRDebitTitle.contains("Debit (-)")) {
            System.out.println("Debit Success");

        } else {
            System.out.println("Debit Failure");
            Assert.fail("Debit Failure");
        }

        QAFExtendedWebElement TRCredit = new QAFExtendedWebElement(By.xpath("//*[@id=\"transactionTable\"]/thead/tr/th[4]"));
        String TRCreditTitle = TRCredit.getText();
        if (TRCreditTitle.contains("Credit (+)")) {
            System.out.println("Credit Success");

        } else {
            System.out.println("Credit Failure");
            Assert.fail("Credit Failure");
        }

//        throw new PendingException();
    }


    // Update contact info
    //        throw new PendingException();
    @When("^the user clicks on the Update Contact Info button$")
    public void the_user_clicks_on_the_Update_Contact_Info_button() throws Throwable {
        QAFExtendedWebElement UpdateContactInfo = new QAFExtendedWebElement(By.xpath("//a[normalize-space()='Update Contact Info']"));
        UpdateContactInfo.click();
        QAFExtendedWebElement UpdateProfile = new QAFExtendedWebElement(By.xpath("//h1[normalize-space()='Update Profile']"));
        String UPTitle = UpdateProfile.getText();
        if (UPTitle.contains("Update Profile")) {
            System.out.println("Update Profile Success");
        } else {
            System.out.println("Update Profile Failure");
            Assert.fail("Update Profile Failure");
        }
    }
//        throw new PendingException();


    @When("^the user enters all the necessary details$")
    public void the_user_enters_all_the_necessary_details() throws Throwable {
        QAFExtendedWebElement FirstName = new QAFExtendedWebElement(By.id("customer.firstName"));
        FirstName.clear();
        FirstName.sendKeys("John1");
        QAFExtendedWebElement LastName = new QAFExtendedWebElement(By.id("customer.lastName"));
        LastName.clear();
        LastName.sendKeys("Smith1");
        QAFExtendedWebElement Address = new QAFExtendedWebElement(By.id("customer.address.street"));
        Address.clear();
        Address.sendKeys("1234 progress avenue");
        QAFExtendedWebElement City = new QAFExtendedWebElement(By.id("customer.address.city"));
        City.clear();
        City.sendKeys("Austin");
        QAFExtendedWebElement State = new QAFExtendedWebElement(By.id("customer.address.state"));
        State.clear();
        State.sendKeys("OH");
        QAFExtendedWebElement ZipCode = new QAFExtendedWebElement(By.id("customer.address.zipCode"));
        ZipCode.clear();
        ZipCode.sendKeys("42532");
        QAFExtendedWebElement Phone = new QAFExtendedWebElement(By.id("customer.phoneNumber"));
        Phone.clear();
        Phone.sendKeys("1234567890");
        Thread.sleep(2000);
//        throw new PendingException();
    }

    @When("^user clicks on the Update Profile Button$")
    public void user_clicks_on_the_Update_Profile_Button() throws Throwable {
        QAFExtendedWebElement UpdateProfileButton = new QAFExtendedWebElement(By.xpath("//input[@value='Update Profile']"));
        UpdateProfileButton.click();
//        throw new PendingException();
    }

    @Then("^the user is displayed with the Profile Updated page$")
    public void the_user_is_displayed_with_the_Profile_Updated_page() throws Throwable {
        QAFExtendedWebElement ProfileUpdatedTitle = new QAFExtendedWebElement(By.xpath("//h1[normalize-space()='Profile Updated']"));
        String PUTitle = ProfileUpdatedTitle.getText();
        if (PUTitle.contains("Profile Updated")) {
            System.out.println("Profile Updated Success");
        } else {
            System.out.println("Profile Updated Failure");
            Assert.fail("Profile Updated Failure");
        }
        Thread.sleep(2000);
//        throw new PendingException();
    }


    // Request loan test case

    @Given("^the user clicks on the Request loan link$")
    public void the_user_clicks_on_the_Request_loan_link() throws Throwable {
        QAFExtendedWebElement RequestLoan = new QAFExtendedWebElement(By.linkText("Request Loan"));
        RequestLoan.click();
        QAFExtendedWebElement ApplyForLoan = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
        String AFLTitle = ApplyForLoan.getText();
        if (AFLTitle.contains("Apply for a Loan")) {
            System.out.println("Apply for a Loan Success");
        } else {
            System.out.println("Apply for a Loan Failure");
            Assert.fail("Apply for a Loan Failure");
        }
    }

    @When("^the user enters the loan amount$")
    public void the_user_enters_the_loan_amount() throws Throwable {
        Thread.sleep(2000);
        QAFExtendedWebElement LoanAmount = new QAFExtendedWebElement(By.xpath("//*[@id=\"amount\"]"));
        LoanAmount.sendKeys("152");
    }

    @When("^the user enters the Down Payment amount$")
    public void the_user_enters_the_Down_Payment_amount() throws Throwable {
        QAFExtendedWebElement DownPayment = new QAFExtendedWebElement(By.xpath("//*[@id=\"downPayment\"]"));
        DownPayment.sendKeys("50");

    }

    @When("^the user selects the from account$")
    public void the_user_selects_the_from_account() throws Throwable {
        QAFExtendedWebElement FromAccountDD = new QAFExtendedWebElement(By.xpath("//*[@id=\"fromAccountId\"]"));
        Select Dropdown6 = new Select(FromAccountDD);
        Dropdown6.selectByIndex(5);

    }

    @When("^the user clicks on the Apply now button$")
    public void the_user_clicks_on_the_Apply_now_button() throws Throwable {
        QAFExtendedWebElement ApplyNowButton = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[4]/td[2]/input"));
        ApplyNowButton.click();
    }

    @Then("^the user is displayed with the Loan Request Processed page$")
    public void the_user_is_displayed_with_the_Loan_Request_Processed_page() throws Throwable {
        QAFExtendedWebElement LoanRequestProcessed = new QAFExtendedWebElement(By.xpath("//h1[normalize-space()='Loan Request Processed']"));
        String LRPTitle = LoanRequestProcessed.getText();
        if (LRPTitle.contains("Loan Request Processed")) {
            System.out.println("Loan Request Processed Success");
        } else {
            System.out.println("Loan Request Processed Failure");
            Assert.fail("Loan Request Processed Failure");
        }
        QAFExtendedWebElement LoanProvider = new QAFExtendedWebElement(By.xpath("//b[normalize-space()='Loan Provider:']"));
        String LPTitle = LoanProvider.getText();
        if (LPTitle.contains("Loan Provider")) {
            System.out.println("Loan Provider Success");
        } else {
            System.out.println("Loan Provider Failure");
            Assert.fail("Loan Provider Failure");
        }


        QAFExtendedWebElement LoanRequestDate = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/table/tbody/tr[2]"));
        String LPDTitle = LoanRequestDate.getText();
        if (LPDTitle.contains("Date")
        ) {
            System.out.println("Loan Provider Date Success");
        } else {
            System.out.println("Loan Provider Date Failure");
            Assert.fail("Loan Provider Date Failure");
        }

        QAFExtendedWebElement LoanRequestStatus = new QAFExtendedWebElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/table/tbody/tr[3]"));
        String LPSTitle = LoanRequestStatus.getText();
        if (LPSTitle.contains("Status")
        ) {
            System.out.println("Loan Provider Status Success");
        } else {
            System.out.println("Loan Provider Status Failure");
            Assert.fail("Loan Provider Status Failure");
        }

    }


    // Logout testcase

    @Given("^the user is in the customer page$")
    public void the_user_is_in_the_customer_page() throws Throwable {
        QAFExtendedWebElement AccountServices = new QAFExtendedWebElement(By.xpath("//h2[normalize-space()='Account Services']"));
        String ASTitle = AccountServices.getText();
        if (ASTitle.contains("Account Services")) {
            System.out.println("Account Services  Success");
        } else {
            System.out.println("Account Services Failure");
            Assert.fail("Account Services Failure");
        }
        Thread.sleep(2000);

//    } throw new PendingException();
    }

    @When("^the user clicks on the Logout button$")
    public void the_user_clicks_on_the_Logout_button() throws Throwable {
        QAFExtendedWebElement LogOut = new QAFExtendedWebElement(By.xpath("//a[normalize-space()='Log Out']"));
        LogOut.click();
//        throw new PendingException();
    }

    @Then("^the user is logged out successfully$")
    public void the_user_is_logged_out_successfully() throws Throwable {
        QAFExtendedWebElement CustomerLogin = new QAFExtendedWebElement(By.xpath("//h2[normalize-space()='Customer Login']"));
        String CLTitle = CustomerLogin.getText();
        if (CLTitle.contains("Customer Login")) {
            System.out.println("Customer Login Success");
        } else {
            System.out.println("Customer Login Failure");
            Assert.fail("Customer Login Failure");
        }

//        throw new PendingException();
    }
}