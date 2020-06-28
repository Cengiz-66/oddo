package com.oddo.stepdefinitions;

import com.oddo.pages.contacts_countriesCreate;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

public class contacts_countries_stepDefs {

    @When("the user clicks {string} submenu")
    public void the_user_clicks_submenu(String submenu) {
        new contacts_countriesCreate().navigateInLeftModule(submenu);
        new Actions(Driver.get()).moveToElement(new contacts_countriesCreate().localization).pause(100).click().perform();
    }

    @When("the user chooses currency as {string} from select box")
    public void the_user_chooses_currency_as_from_select_box(String currency) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        ccc.currency.sendKeys(currency);

    }

    @When("the user enters following information")
    public void the_user_enters_following_information(Map<String, Object> dataTable) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        ccc.countryName.sendKeys((String)dataTable.get("Country Name"));
        ccc.countryCode.sendKeys((String)dataTable.get("Country Code"));
        ccc.countryCallingCode.sendKeys((String)dataTable.get("Country Calling Code"));
        ccc.vatLabel.sendKeys((String)dataTable.get("Vat Label"));

    }

    @Then("the user should see following info on the page")
    public void the_user_should_see_following_info_on_the_page(Map<String, Object> dataTable) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        String actualCountryname=ccc.countryName.getText();
        Assert.assertTrue(actualCountryname.equals((String)dataTable.get("Country Name")));

        String actualCountryCode=ccc.countryCode.getText();
        Assert.assertTrue(actualCountryCode.equals((String)dataTable.get("Country Code")));

        String actualCCallingCode=ccc.countryCallingCode.getText();
        Assert.assertTrue(actualCCallingCode.equals((String)dataTable.get("Country Calling Code")));

        String actualVatLabel=ccc.vatLabel.getText();
        Assert.assertTrue(actualVatLabel.equals((String)dataTable.get("Vat Label")));
    }

    @Then("the user should get {string} warning message")
    public void the_user_should_get_warning_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user comes back to country-create page")
    public void the_user_comes_back_to_country_create_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user reach save or discard screen")
    public void the_user_reach_save_or_discard_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user enter followings")
    public void the_user_enter_followings(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
