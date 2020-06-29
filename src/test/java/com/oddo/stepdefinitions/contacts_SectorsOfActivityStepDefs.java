package com.oddo.stepdefinitions;

import com.oddo.pages.SectorsOfActivity;
import com.oddo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class contacts_SectorsOfActivityStepDefs {

    @When("the user navigates to {string}")
    public void theUserNavigatesTo(String menu) {
        SectorsOfActivity sectorsOfActivity = new SectorsOfActivity();
        sectorsOfActivity.navigateToModule(menu);
    }

    @And("the user clicks to Sectors of Activity")
    public void theUserClicksToSectorsOfActivity() {
        SectorsOfActivity sectorsOfActivity = new SectorsOfActivity();
        sectorsOfActivity.sectorsOfActivity.click();
        BrowserUtils.waitFor(2);
    }


    @Then("the numbers of sectors in the list is equal to the number on top right of the page")
    public void the_numbers_of_sectors_in_the_list_is_equal_to_the_number_on_top_right_of_the_page() {
        SectorsOfActivity sectorsOfActivity = new SectorsOfActivity();
        int sectorsInList = sectorsOfActivity.allRows.size();
        int numberTopRight = Integer.parseInt(sectorsOfActivity.numberOfSectors.getText());

        BrowserUtils.waitFor(1);
        Assert.assertEquals("verify the numbers of sectors are equal", sectorsInList, numberTopRight);

    }

    @When("the user clicks checkbox on the page")
    public void theUserClicksCheckboxOnThePage() {
        new SectorsOfActivity().checkBox.click();
        BrowserUtils.waitFor(3);

    }

    @Then("action menu is displayed")
    public void action_menu_is_displayed() {
        Assert.assertTrue(new SectorsOfActivity().actionMenu.isDisplayed());
    }

    @When("the user selects following {string} from action menu")
    public void the_user_selects_following_from_action_menu(String option) {
        SectorsOfActivity sectorsOfActivity = new SectorsOfActivity();
        sectorsOfActivity.actionMenu.click();
        sectorsOfActivity.getActionMenu(option).click();
    }


    @Then("{string} is shown on the page")
    public void isShownOnThePage(String expectedMessage) {
        BrowserUtils.waitFor(5);
        Assert.assertTrue("verify the message is displayed",new SectorsOfActivity().actualErrorMessage.getText().contains(expectedMessage));
    }
}