package com.oddo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact_BankAccountPage extends BasePage {

    @FindBy(xpath = " (//*[contains(text(),'Bank Account')])[2]")
    public WebElement secondBankAccountLink;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createButton;



}
