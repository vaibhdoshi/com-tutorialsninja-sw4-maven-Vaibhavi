package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccount myAccount = new MyAccount();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterFirstname("Pranali" + getAlphaNumericString(7));
        myAccount.enterLastname("Patel" + getAlphaNumericString(5));
        myAccount.enterEmail("test123" + getAlphaNumericString(7) + "@gmail.com");
        myAccount.enterTelephone("0789562566");
        myAccount.enterPassword("test123");
        myAccount.enterConfirmPassword("test123");
        myAccount.selectRadioButton();
        myAccount.clickONPrivacyCheck();
        myAccount.clickOnContinueButton();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(myAccount.getRegistrationConfirmMessage(), expectedMessage, "Message not displyed");
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage1 = "Account Logout";
        Assert.assertEquals(myAccount.getLogoutMessage(), expectedMessage1, "Not Logout");


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        loginPage.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        loginPage.enterEmail("test123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getMyAccountText(), "My Account", "Login Not Successfull");
        loginPage.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage1 = "Account Logout";
        Assert.assertEquals(myAccount.getLogoutMessage(), expectedMessage1, "Not Logout");
        loginPage.clickOnContinueButton();


    }


}
