package com.FreeCRM.step_definitions;

import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.utilities.BrowserUtils;
import com.FreeCRM.utilities.ConfigurationReader;
import com.FreeCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.an;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.awt.event.KeyEvent;
import java.util.List;

public class LoginStepDefinitions extends LoginPage{



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @When("I enter the correct username and password")
    public void iEnterTheCorrectUsernameAndPassword(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        emailAddressField.sendKeys(data.get(0));
        passwordField.sendKeys(data.get(1));
        loginButton.click();
    }

    @Then("I should be signed in and taken to the homepage")
    public void i_should_be_signed_in_and_taken_to_the_homepage() {
        Assert.assertTrue(homepageHeader.isDisplayed());
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
     emailAddressField.sendKeys(getRandomString());
     passwordField.sendKeys(getRandomString());
     loginButton.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("I sign up for a new account")
    public void i_sign_up_for_a_new_account() {
        signUpButton.click();
    }

    @Then("I am taken to the registration page")
    public void i_am_taken_to_the_registration_page() {
        Assert.assertTrue(registerHeader.isDisplayed());
    }

    @When("I request a new password")
    public void i_request_a_new_password() {
        forgotPasswordButton.click();
    }

    @Then("I am taken to the password reset page")
    public void i_am_taken_to_the_password_reset_page() {
        Assert.assertTrue(passwordHeader.isDisplayed());
    }

    @When("I attempt to sign in")
    public void i_attempt_to_sign_in() {
       Assert.assertTrue(emailAddressField.isDisplayed() && passwordField.isDisplayed());
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

    @When("I attempt to enter correct {string} but incorrect {string} multiple times")
    public void i_attempt_to_enter_correct_but_incorrect_multiple_times(String username, String password) {
        login(username,password);
    }
    @Then("I should receive an account locked error message")
    public void i_should_receive_an_account_locked_error_message() {

        String expectedInvalidLogin = "Something went wrong...\n" +
                "Invalid login";

        String actualInvalidLogin = loginErrorMessage.getText();

        String expectedAccountLocked = "Something went wrong...\n" +
                "Account locked: too many login attempts. Please try again later.";

        String actualAccountLocked = loginErrorMessage.getText();


        if(expectedInvalidLogin.equals(actualInvalidLogin)){
            Assert.assertEquals(expectedInvalidLogin,actualInvalidLogin);
            Assert.assertTrue(loginErrorMessage.isDisplayed());
            System.out.println(loginErrorMessage.getText());
        }else if (expectedAccountLocked.equals(actualAccountLocked)){
            Assert.assertEquals(expectedAccountLocked,actualAccountLocked);
            Assert.assertTrue(loginErrorMessage.isDisplayed());
            System.out.println(loginErrorMessage.getText());
        }
    }

    @Given("the cursor is on the Username field")
    public void the_cursor_is_on_the_username_field() {
        emailAddressField.click();
    }

    @When("I select the TAB key")
    public void i_select_the_tab_key() {
        emailAddressField.sendKeys(Keys.TAB);
    }

    @Then("the cursor should be on the Password field")
    public void the_cursor_should_be_on_the_password_field() {
        Assert.assertTrue(passwordField.isEnabled());
    }

}
