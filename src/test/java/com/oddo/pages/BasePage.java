package com.oddo.pages;

import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".breadcrumb")
    public WebElement secondaryTitle;

    @FindBy(xpath = "//*[.='Loading']")
    public WebElement loadingBar;

    @FindBy(css = "oe_blockui_spin")
    public WebElement loadingSpin;

    @FindBy(css = ".blockUI.blockOverlay")
    public WebElement loadingOverlay;

    //after landing a page, this waits for the given secondary title
    public void waitUntilSecondaryTitleContains(String waitForTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.textToBePresentInElement(secondaryTitle, waitForTitle));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //loading black overlay
    public void waitUntilLoadingOverlayDisappears() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
            wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitUntilLoadingBarDisappears() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
            wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilTitleToContain(String title) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * This method will navigate user to the specific module in Zerobank application.
     * For example: if tab is equals to PayBills, and module equals to Pay saved Payee,
     * Then method will navigate user to this page: http://zero.webappsecurity.com/bank/
     *
     * @param upperMenu
     * @param leftMenu
     */
    public void navigateToModule(String upperMenu, String leftMenu) {
        try {
            BrowserUtils.waitForClickablility(By.partialLinkText(upperMenu), 5);
            WebElement tabElement = Driver.get().findElement(By.partialLinkText(upperMenu));
            tabElement.click();
            //new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.partialLinkText(upperMenu), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.partialLinkText(leftMenu), 5);
            BrowserUtils.waitForVisibility(By.partialLinkText(leftMenu), 5);
            Driver.get().findElement(By.partialLinkText(leftMenu)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.partialLinkText(leftMenu)), 5);
        }

    }

    //to navigate with only upperMenu
    public void navigateToModule(String upperMenu) {
        try {
            BrowserUtils.waitForClickablility(By.linkText(upperMenu), 5);
            WebElement tabElement = Driver.get().findElement(By.linkText(upperMenu));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(upperMenu), 5);
        }
    }



    //to click common buttons
    public void clickButtonName(String buttonName){
        String xpath = "//button[contains(text(),'"+buttonName+"')]";
        Driver.get().findElement(By.xpath(xpath)).click();
    }



    // this is to return select object of a select element
    public Select returnSelectObject(WebElement selectDropDown) {

        return new Select(selectDropDown);
    }



    // this is to check whether an alert is present or not
    public boolean isAlertPresent() {
        try {
            Driver.get().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

}