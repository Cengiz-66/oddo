package com.oddo.stepdefinitions;

import com.oddo.pages.ContactsPage;
import com.oddo.pages.ContactsTitlePage;
import com.oddo.pages.LoginPage;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsTitleEnder {


    @When("the user clicks Contact Titles submenu")
    public void the_user_clicks_Contact_Titles_submenu() {
        new LoginPage().loginAs("crmManager");

        BrowserUtils.waitFor(8);
        new ContactsTitlePage().goTitle("Contacts");
        BrowserUtils.waitFor(12);

        new ContactsTitlePage().titleMenu.click();
    }

    @When("the user clicks create button")
    public void the_user_clicks_create_button() {

        BrowserUtils.waitFor(10);
        new ContactsTitlePage().createTitle.click();
    }

/*
    @When("the user enters following information")
    public void the_user_enters_following_information(Map<String, String> table) {

        BrowserUtils.waitFor(10);


        new ContactsTitlePage().titleBox.sendKeys(table.get("Title")+ Keys.TAB);
        new ContactsTitlePage().abbri.sendKeys(table.get("Abbreviation"));

        BrowserUtils.waitFor(5);



    }*/

    @When("the user clicks Save button")
    public void the_user_clicks_Save_button() {
        new ContactsTitlePage().save.click();
    }


    @Then("the user should see the following title")
    public void the_user_should_see_the_following_title(Map<String,String> title) {
        String actualTitle = new ContactsTitlePage().saveMssg.getText();
        String expectedTitle = title.get("Title");
        Assert.assertEquals(expectedTitle, actualTitle);


    }
    @When("the user leaves the title box empty")
    public void the_user_leaves_the_title_box_empty() {
        BrowserUtils.waitFor(10);


        new ContactsTitlePage().titleBox.sendKeys(Keys.TAB);

        BrowserUtils.waitFor(12);
        new ContactsTitlePage().save.click();

    }

    @Then("the user get {string} message")
    public void the_user_get_message(String excp) {
        BrowserUtils.waitForPresenceOfElement(By.xpath("//*[@class='o_notification_title']"),8);

        WebElement element1=new ContactsTitlePage().popupMsg1;
        WebElement element2=new ContactsTitlePage().popupMsg2;
       // wait.until(ExpectedConditions.presenceOfElementLocated();

        String text = element1.getText()+" "+element2.getText();




         excp="The following fields are invalid: Title";

        Assert.assertEquals(text,excp);

    }


}