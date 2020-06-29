package com.oddo.stepdefinitions;

import com.oddo.pages.Contact_BankAccountPage;
import com.oddo.pages.contacts_countriesCreate;
import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

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
        Assert.assertTrue(actualCountryCode.equalsIgnoreCase((String)dataTable.get("Country Code")));

        String actualCCallingCode=ccc.countryCallingCode.getText();
        Assert.assertTrue(actualCCallingCode.equals((String)dataTable.get("Country Calling Code")));

        String actualVatLabel=ccc.vatLabel.getText();
        Assert.assertTrue(actualVatLabel.equalsIgnoreCase((String)dataTable.get("Vat Label")));
    }

    @Then("the user clicks {string} button in pop up window")
    public void the_user_clicks_button_in_pop_up_window(String buttonName) {
        new contacts_countriesCreate().OkOrCancelinWarning(buttonName).click();
    }
    @Then("the user should get {string} warning message")
    public void the_user_should_get_warning_message(String text) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        String actualText = ccc.getMessageInWarningBox(text);
        Assert.assertTrue("Warning message verify",actualText.contains(text));

    }
    @Given("the user clicks {string} button for confirmation")
    public void the_user_clicks_button_for_confirmation(String buttonName) {
        new contacts_countriesCreate().clickForConfirmationButton(buttonName);
        new contacts_countriesCreate().waitUntilTitleToContain("New");
        System.out.println(new contacts_countriesCreate().getPageSubTitle());
    }

    @Then("the user comes back to country-create page")
    public void the_user_comes_back_to_country_create_page() {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        BrowserUtils.waitFor(1);
        String pageSubTitle = ccc.getPageSubTitle();
        System.out.println("pageSubTitle = " + pageSubTitle);
        Assert.assertTrue("Subtitle verification",pageSubTitle.equals("Countries"));
    }

    @Then("the user should get {string} alert")
    public void the_user_should_get_alert(String alertMessage) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        String actualText = ccc.getRedMessageInWarningBox(alertMessage);
        System.out.println("messageInWarningBox = " + actualText);
        Assert.assertTrue("Alert verification",actualText.contains(alertMessage));
    }

    @When("the user enters {string} in search box end clicks enter button")
    public void the_user_enters_in_search_box_end_clicks_enter_button(String word)  {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        ccc.waitUntilLoadingBarDisappears();
        BrowserUtils.waitFor(1);
        ccc.searchInput.sendKeys(word, Keys.ENTER);
        BrowserUtils.waitForVisibility(ccc.searchWordInBox,2);
        ccc.searchButton.click();

    }
    @Then("111111the user should see following options11111111") // Parametre çalışması yapıldı. Feature file'ın altında 4 sütünlu verilerle
    public void the_user_should_see_following_options111111(Map<String,List<String>> expected) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        ccc.waitUntilLoadingBarDisappears();
        BrowserUtils.verifyElementDisplayed(ccc.searchWordInBox);
        List<String> actualCountryNames = BrowserUtils.getElementsText(ccc.tableCountryNamesList);
        List<String> actualCountryCodes = BrowserUtils.getElementsText(ccc.tableCountryCodesList);

        List<String> expectedCountry_codes = expected.get("Country Code");
        //System.out.println("expectedCountry_codes = " + expectedCountry_codes);
        List<String> expectedCountry_names = expected.get("Country Name");
        //System.out.println("expectedCountry_names = " + expectedCountry_names);

        System.out.println("Value size: "+expected.values().size());
        System.out.println("keySet size: "+expected.keySet().size());
        System.out.println("expected.get(\"Country Name\").size() = " + expected.get("Country Name").size());

        int num=0;
        for (int i = 0; i <expected.values().size() ; i++) {
            if(actualCountryNames.get(i).equals(expectedCountry_names.get(i)) && actualCountryCodes.get(i).equals(expectedCountry_codes.get(i))){
                System.out.println("Verified!!!!!"); num=i;
                break;
            }
        }
        System.out.println("Num:"+num);
        Assert.assertTrue("Searched country name verification",actualCountryNames.get(num).equals(expectedCountry_names.get(num)) && actualCountryCodes.get(num).equals(expectedCountry_codes.get(num)));
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(Map<String,String> expected) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        ccc.waitUntilLoadingBarDisappears();
        BrowserUtils.verifyElementDisplayed(ccc.searchWordInBox);
        List<String> actualCountryNames = BrowserUtils.getElementsText(ccc.tableCountryNamesList);
        List<String> actualCountryCodes = BrowserUtils.getElementsText(ccc.tableCountryCodesList);
        String expectedCountry_name = expected.get("Country Name");
        String expectedCountry_code = expected.get("Country Code");
        int num=0;
        for (int i = 0; i <actualCountryCodes.size() ; i++) {
            if(expectedCountry_name.equals(actualCountryNames.get(i)) && expectedCountry_code.equals(actualCountryCodes.get(i))){
                num=i;
                break;
            }
        }

        Assert.assertTrue("Country name, code verification",
                expectedCountry_name.equals(actualCountryNames.get(num))
                        && expectedCountry_code.equals(actualCountryCodes.get(num)));

    }

    @When("the user selects one country from list")
    public void the_user_selects_one_country_from_list() {
       contacts_countriesCreate ccc=new contacts_countriesCreate();
        int CountrySize = ccc.tableCountryNamesList.size();
        System.out.println("CountrySize = " + CountrySize);
        int random=(int)(Math.random()*4)+1;// 4 yerine CountrySize olması gerekiyor
        System.out.println("random number= " + random);
        //ccc.waitUntilLoadingOverlayDisappears();
        ccc.waitUntilLoadingBarDisappears();
        BrowserUtils.waitFor(1);


        String selectedCountry = BrowserUtils.getElementsText(ccc.tableCountryNamesList).get(random);
        System.out.println("selectedCountry = " + selectedCountry);
        BrowserUtils.scrollToElement(ccc.tableCountryNamesList.get(1));//1 yerine random olması gerekiyor
        ccc.tableCountryNamesList.get(1).click();

    }

    @When("selects {string} under Actions button")
    public void selects_under_Actions_button(String string) {
        contacts_countriesCreate ccc=new contacts_countriesCreate();
        BrowserUtils.waitFor(1);
        //BrowserUtils.waitForClickablility(ccc.actionsButton,5);
        ccc.actionsButton.click();
        BrowserUtils.waitForClickablility(ccc.deleteButton,5);
        ccc.deleteButton.click();

    }

    @Then("the user sends a CSV file as input")
    public void the_user_sends_a_CSV_file_as_input() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see some data under at least following options")
    public void the_user_should_see_some_data_under_at_least_following_options(io.cucumber.datatable.DataTable dataTable) {
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
