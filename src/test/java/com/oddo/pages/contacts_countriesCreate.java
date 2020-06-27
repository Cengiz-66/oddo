package com.oddo.pages;

import com.oddo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class contacts_countriesCreate extends BasePage {

   @FindBy(name = "name")
    public WebElement countryName;

   @FindBy(xpath = "//div[@name='currency_id']/div/input")
    public WebElement currency;

   @FindBy(name = "code")
   public WebElement countryCode;

   @FindBy(name = "phone_code")
   public WebElement countryCallingCode;

   @FindBy(name = "vat_label")
   public WebElement vatLabel;





}
