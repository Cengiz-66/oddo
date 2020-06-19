package com.oddo.pages;

import com.oddo.utilities.ConfigurationReader;
import com.oddo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

@FindBy(id = "login")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[.='Log in']")
    public WebElement loginButton;

    public void loginAs(String userType){
        Driver.get().manage().window().maximize();
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String username = ConfigurationReader.get(userType+"_username");
        String password = ConfigurationReader.get(userType+"_password");
        LoginPage loginPage = new LoginPage();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }




}
