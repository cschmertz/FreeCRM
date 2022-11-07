package com.FreeCRM.step_definitions;

import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.utilities.BrowserUtils;
import com.FreeCRM.utilities.ConfigurationReader;
import com.FreeCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Cookie;

import java.util.List;

public class LoginStepDefinitions {

    LoginPage lp = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @When("I enter the correct username and password")
    public void iEnterTheCorrectUsernameAndPassword(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        lp.emailAddressField.sendKeys(data.get(0));
        lp.passwordField.sendKeys(data.get(1));
        lp.loginButton.click();
    }

    @Then("I should be signed in and taken to the homepage")
    public void i_should_be_signed_in_and_taken_to_the_homepage() {
        Assert.assertTrue(lp.homepageHeader.isDisplayed());
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
     lp.emailAddressField.sendKeys(lp.getRandomString());
     lp.passwordField.sendKeys(lp.getRandomString());
     lp.loginButton.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(lp.errorMessage.isDisplayed());
    }

    @When("I sign up for a new account")
    public void i_sign_up_for_a_new_account() {
        lp.signUpButton.click();
    }

    @Then("I am taken to the registration page")
    public void i_am_taken_to_the_registration_page() {
        Assert.assertTrue(lp.registerHeader.isDisplayed());
    }

    @When("I request a new password")
    public void i_request_a_new_password() {
        lp.forgotPasswordButton.click();
    }

    @Then("I am taken to the password reset page")
    public void i_am_taken_to_the_password_reset_page() {
        Assert.assertTrue(lp.passwordHeader.isDisplayed());
    }

    @When("I attempt to sign in")
    public void i_attempt_to_sign_in() {
       Assert.assertTrue(lp.emailAddressField.isDisplayed() && lp.passwordField.isDisplayed());
    }

    @Then("cookies should be enabled")
    public void cookies_should_be_enabled() {
        //creating a new cookie, adding it, then asserting that it exists
        Cookie cookie = new Cookie("name","value");
        Driver.getDriver().manage().addCookie(cookie);
        Assert.assertEquals(cookie.getValue(), Driver.getDriver().manage().getCookieNamed(cookie.getName()).getValue());
        Assert.assertEquals("value", cookie.getValue());
        Assert.assertEquals("name" , cookie.getName());
    }

}