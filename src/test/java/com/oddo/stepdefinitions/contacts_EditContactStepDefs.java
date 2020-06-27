package com.oddo.stepdefinitions;

import com.oddo.pages.ContactsPage;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

public class contacts_EditContactStepDefs {
    String contact = "";

    @When("the user click {string} contact")
    public void the_user_click_contact(String contactName) {
        new ContactsPage().selectContact(contactName).click();
        new ContactsPage().waitUntilTitleToContain(contactName);
        contact = contactName;
    }


    @Then("user should see all information to that contact")
    public void user_should_see_all_information_to_that_contact() {
        Assert.assertTrue("Verify that page subtitle contain contact name", new ContactsPage().getPageSubTitle().contains(contact));
    }


    @When("the user enter following information")
    public void the_user_enter_following_information(Map<String, String> editContactInfo) {
        ContactsPage contactsPage = new ContactsPage();
        //new Actions(Driver.get()).moveToElement(contactsPage.nameInputBox).doubleClick().doubleClick().perform();
        contactsPage.nameInputBox.clear();
        contactsPage.nameInputBox.sendKeys(Keys.BACK_SPACE, editContactInfo.get("Name"));
        contactsPage.phoneInputBox.clear();
        contactsPage.phoneInputBox.sendKeys(Keys.BACK_SPACE, editContactInfo.get("Phone"));
        contactsPage.mobileInputBox.clear();
        contactsPage.mobileInputBox.sendKeys(Keys.BACK_SPACE, editContactInfo.get("Mobile"));
        contactsPage.emailInputBox.clear();
        contactsPage.emailInputBox.sendKeys(Keys.BACK_SPACE, editContactInfo.get("Email"));
    }


}
