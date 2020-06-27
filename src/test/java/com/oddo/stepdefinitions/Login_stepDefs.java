package com.oddo.stepdefinitions;

import com.oddo.pages.LoginPage;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.ConfigurationReader;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepDefs {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().manage().window().maximize();
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }


    @When("the user enter the {string} information")
    public void the_user_enter_the_information(String userType) {
        String crm_username = ConfigurationReader.get(userType+"_username");
        String crm_password = ConfigurationReader.get(userType+"_password");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameField.sendKeys(crm_username);
        loginPage.passwordField.sendKeys(crm_password);
        loginPage.loginButton.click();
    }


    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String title = Driver.get().getTitle();
        Assert.assertFalse("title should not contain login: current :"+title,title.contains("Login"));
    }
}
