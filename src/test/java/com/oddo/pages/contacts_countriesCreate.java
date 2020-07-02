package com.oddo.pages;

import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

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

   @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement WarningForDiscard;

   @FindBy(xpath = "//div[@class='o_notification_title']")
   public WebElement warningAlert;

   @FindBy(xpath = "//div[.='Country Calling Code']")
   public WebElement warningCallingCountryCode;

   public WebElement OkOrCancelinWarning(String buttonName){
       return Driver.get().findElement(By.xpath("//div[@class='modal-dialog']//button[.='"+buttonName+"']"));
   }

   public String getMessageInWarningBox(String text){
        return Driver.get().findElement(By.xpath("//div[contains(text(),'"+text+"')]")).getText();//div[.='Country Calling Code']
   }

   public String getRedMessageInWarningBox(String text){
       return Driver.get().findElement(By.xpath("//div[.='"+text+"']")).getText();//div[.='Country Calling Code']
   }

   @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='table-responsive']//th")
    public List<WebElement> tableHeadings;

   @FindBy(xpath = "//div[@class='table-responsive']//th[2]")
    public WebElement tableCountryNameHeading;

    @FindBy(xpath = "//div[@class='table-responsive']//td[2]")
    public List<WebElement> tableCountryNamesList;

    @FindBy(xpath = "//div[@class='table-responsive']//th[3]")
    public WebElement tableCountryCodeHeading;

    @FindBy(xpath = "//div[@class='table-responsive']//td[3]")
    public List<WebElement> tableCountryCodesList;

    @FindBy(xpath = "//tbody[@class='ui-sortable']")
    public WebElement tableCountriesAfterSearch;

    @FindBy(xpath = "//div[@class='o_searchview_facet']")
    public WebElement searchWordInBox;

    @FindBy(xpath = "//span[@class='o_searchview_more fa fa-search-plus']")
    public WebElement searchButton;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")
    public WebElement actionsButton;

    @FindBy(xpath = "(//ul[@class='dropdown-menu']/li)[8]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement deleteWarningMessage;


}
