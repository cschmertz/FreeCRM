package com.FreeCRM.pages;

import com.FreeCRM.utilities.Driver;
import com.github.javafaker.Faker;
import com.github.jscookie.javacookie.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Faker faker = new Faker();

    @FindBy(css = "input[name = 'email']")
    public WebElement emailAddressField;

    @FindBy(css = "input[name = 'password']")
    public WebElement passwordField;

    @FindBy(css = "div[class = 'ui fluid large blue submit button']")
    public WebElement loginButton;

    @FindBy(css = "a[href = 'https://register.cogmento.com/password/reset/request/']")
    public WebElement forgotPasswordButton;

    @FindBy(css = "a[href = 'https://api.cogmento.com/register']")
    public WebElement signUpButton;

    @FindBy(css = "div[class = 'header']")
    public WebElement errorMessage;

    @FindBy(css = "h2[class = 'ui blue header']")
    public WebElement registerHeader;

    @FindBy(css = "h2[class = 'ui blue header']")
    public WebElement passwordHeader;

    @FindBy(css = "div[class = 'header item']")
    public WebElement homepageHeader;

    @FindBy(css = "div[class = 'ui negative message']")
    public WebElement loginErrorMessage;

    String randomString = faker.toString();

    public String getRandomString() {
        return randomString;
    }


    public javax.servlet.http.HttpServletRequest request;
    public javax.servlet.http.HttpServletResponse response;
    public Cookies cookies = Cookies.initFromServlet( request, response );

    public void login(String username,String password){

        emailAddressField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }



}
