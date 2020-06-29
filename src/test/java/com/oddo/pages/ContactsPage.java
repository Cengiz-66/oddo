package com.oddo.pages;

import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "(//div/input[@class=\"o_radio_input\"])[1]")
    public WebElement individualRadioButton;

    @FindBy(xpath = "(//div/input[@class=\"o_radio_input\"])[2]")
    public WebElement companyRadioButton;

    @FindBy(xpath = "//div[@name=\"parent_id\"]//input[starts-with(@id,'o_field_input_')]")
    public WebElement companyDropDown;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement nameInputBox;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement streetInputBox;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInputBox;

    @FindBy(xpath = "//div[@name='country_id']//input")
    public WebElement countryInputBox;

    @FindBy(xpath = "//input[@name='function']")
    public WebElement jobPositionInputBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//input[@name='mobile']")
    public WebElement mobileInputBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;




//this method select a country from address drop down
    @FindBy(xpath = "//*[contains(text(),'ABC Company')]")
    public WebElement savedContact27;

    public void selectCountry(String country) {
        String c = "//li[.='" + country + "']";
        WebElement countrySelect = Driver.get().findElement(By.xpath(c));
        BrowserUtils.waitForVisibility(countrySelect, 5);
        new Actions(Driver.get()).moveToElement(countrySelect).click().perform();
    }

//this method returns WebElement which related given contact name
    public WebElement selectContact(String contactName) {
        String savedContact= "//*[contains(text(),'"+contactName+"')]";

        return Driver.get().findElement(By.xpath(savedContact));
    }

}
