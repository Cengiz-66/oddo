package com.oddo.stepdefinitions;

import com.oddo.pages.BasePage;
import com.oddo.pages.Contact_BankAccountPage;
import com.oddo.pages.LoginPage;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class contacts_BankAccount_stepDefs extends BasePage {

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String userType) {
        new LoginPage().loginAs(userType);
        waitUntilTitleToContain("Inbox");
    }



    @Given("the user navigate to {string} and {string}")
    public void the_user_navigate_to(String upperMenu, String leftMenu) {
        new Contact_BankAccountPage().navigateToModule(upperMenu, leftMenu);

    }

    @Given("clicks to bank accounts link")
    public void clicks_to_bank_accounts_link() {
        new Contact_BankAccountPage().secondBankAccountLink.click();
        new Contact_BankAccountPage().waitUntilTitleToContain("Account");
        System.out.println(new Contact_BankAccountPage().getPageSubTitle());

    }

    @Given("the user clicks {string} button")
    public void the_user_clicks_button(String buttonName) {
        new Contact_BankAccountPage().clickButtonName(buttonName);
        new Contact_BankAccountPage().waitUntilTitleToContain("New");
        System.out.println(new Contact_BankAccountPage().getPageSubTitle());
    }


    @Then("title should contain {string}")
    public void title_should_contain(String expTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue("current title : "+actualTitle,actualTitle.contains(expTitle));
    }

}
