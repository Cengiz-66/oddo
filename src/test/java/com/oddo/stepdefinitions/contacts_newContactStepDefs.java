package com.oddo.stepdefinitions;


import com.oddo.pages.ContactsPage;
import com.oddo.pages.LoginPage;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class contacts_newContactStepDefs {

    @Given("the user logged in")
    public void the_user_logged_in() {
        new LoginPage().loginAs("crmManager");
        new LoginPage().waitUntilTitleToContain("Inbox");
    }

    @Given("the user navigate to {string}")
    public void the_user_navigate_to(String upperMenu) {
        new ContactsPage().navigateToModule(upperMenu);
    }

    @Given("the user click {string} button")
    public void the_user_click_button(String create) {
        new ContactsPage().clickButtonName(create);
    }

    @Then("the user can see individual radio button selected")
    public void the_user_can_see_individual_radio_button_selected() {
        BrowserUtils.waitForVisibility(new ContactsPage().individualRadioButton, 5);
        Assert.assertTrue("Individual radio button is selected!", new ContactsPage().individualRadioButton.isSelected());
    }

    @Then("company drop down is visible")
    public void company_drop_down_is_visible() {
        Assert.assertTrue("Company drop down is visible", new ContactsPage().companyDropDown.isDisplayed());
    }

    @When("the user enters the following information")
    public void the_user_enters_the_following_information(Map<String, String> newContactInfo) {
        ContactsPage contactsPage = new ContactsPage();
        BrowserUtils.waitForVisibility(contactsPage.nameInputBox, 5);
        contactsPage.nameInputBox.sendKeys(newContactInfo.get("Name"));
        contactsPage.streetInputBox.sendKeys(newContactInfo.get("Street"));
        contactsPage.cityInputBox.sendKeys(newContactInfo.get("City"));
        contactsPage.countryInputBox.click();
        contactsPage.selectCountry(newContactInfo.get("Country"));
        try {
            contactsPage.jobPositionInputBox.sendKeys(newContactInfo.get("Job Position"));
        } catch (Exception ignored) {}
        contactsPage.phoneInputBox.sendKeys(newContactInfo.get("Phone"));
        contactsPage.mobileInputBox.sendKeys(newContactInfo.get("Mobile"));
        contactsPage.emailInputBox.sendKeys(newContactInfo.get("Email"));

    }

    @Then("title contains {string}")
    public void title_contains(String contactName) {
       new ContactsPage().waitUntilTitleToContain(contactName);
       Assert.assertTrue("New contact created",new ContactsPage().getPageSubTitle().contains(contactName));
    }

    @When("the user click company radio button")
    public void the_user_click_company_radio_button() {
        BrowserUtils.waitForVisibility(new ContactsPage().companyRadioButton, 5);
        new ContactsPage().companyRadioButton.click();
    }

    @Then("the user can see company radio button selected")
    public void the_user_can_see_company_radio_button_selected() {
        Assert.assertTrue("Company radio button is selected!", new ContactsPage().companyRadioButton.isSelected());

    }

    @Then("{string} is NOT visible")
    public void is_NOT_visible(String companyDropDown) {
        BrowserUtils.waitFor(2);
        Assert.assertFalse("Company drop down is NOT visible", new ContactsPage().companyDropDown.isDisplayed());
    }

    @Then("{string} is not visible")
    public void is_not_visible(String joBPos) {
        Assert.assertFalse("Job position input box is NOT visible", new ContactsPage().jobPositionInputBox.isDisplayed());
    }

}
