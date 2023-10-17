package com.quantum.steps;

import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Map;

@QAFTestStepProvider
public class ParabankOutlineStepDefs {

//    @QAFTestStep(description="the user enters the Username as {0} and password as {1}")
//    public void theUserEntersTheUsernameAsAndPasswordAs(String str0,String str1){
//        //TODO: remove NotYetImplementedException and call test steps
//        throw new NotYetImplementedException();
//    }
//
//    @QAFTestStep(description="the user enters the ${0}")
//    public void theUserEntersThe(Map<Object,Object> mapObj0){
//        //TODO: remove NotYetImplementedException and call test steps
//        throw new NotYetImplementedException();
//    }

    @When("^the user enters the Username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void the_user_enters_the_Username_as_and_password_as(String arg1, String arg2) throws Throwable {
        QAFExtendedWebElement userName = new QAFExtendedWebElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(arg1);
        QAFExtendedWebElement passWord = new QAFExtendedWebElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(arg2);
//        throw new PendingException();
    }

    @When("^the user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_enters_the_and(String arg1, String arg2) throws Throwable {
        QAFExtendedWebElement userName = new QAFExtendedWebElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(arg1);
        QAFExtendedWebElement passWord = new QAFExtendedWebElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(arg2);
//        throw new PendingException();
    }
}


