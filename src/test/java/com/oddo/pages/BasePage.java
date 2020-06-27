package com.oddo.pages;

import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[.='Loading']")
    @CacheLookup
    public WebElement loadingBar;

    @FindBy(css = "oe_blockui_spin")
    public WebElement loadingSpin;

    @FindBy(css = ".blockUI.blockOverlay")
    public WebElement loadingOverlay;

    @FindBy(css = "ol[class='breadcrumb'] ") //-->"ol>li[class='active']"
    public WebElement pageSubTitle;


    @FindBy(css = "[class='oe_topbar_name']")
    public WebElement userName;

    @FindBy(xpath = "(//*[.='Log out'])[1]")
    public WebElement logOutLink;

    @FindBy(xpath = "//span[contains(text(),'Localization')]")
    public WebElement localization;

    @FindBy(xpath = "(//span[contains(text(),'Bank Accounts')])[1]")
    public WebElement bankAccounts;

    @FindBy(xpath = "//span[contains(text(),'Leads & Opportunities')]")
    public WebElement leadsAndOpportunities;

    @FindBy(xpath = "(//span[contains(text(),'eCommerce')])[1]")
    public WebElement eCommerce;

    @FindBy(xpath = "(//span[contains(text(),'Products')])[3]")
    public WebElement products;


    /**
     * @return page name, for example: Contacts
     */
    public String getPageSubTitle() {

        //any time we are verifying page name, or page subtitle, loader mask appears
        //waitUntilLoaderScreenDisappear();
        //BrowserUtils.waitForStaleElement(pageSubTitle);
        //BrowserUtils.waitFor(2);
        BrowserUtils.waitForPageToLoad(5);
        return pageSubTitle.getText();
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */

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

    public String getUserName(){
        //waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        new Actions(Driver.get()).moveToElement(userName).pause(100).click().perform();
        new Actions(Driver.get()).moveToElement(logOutLink).click().perform();

    }

    /**
     * This method will navigate user to the specific module in briteerp application.
     * For example: if tab is equals to Contacts, and module equals to Contact Tags,
     * Then method will navigate user to this page: http://app.briteerp.com/web?#view_type=list&model=res.partner.category&menu_id=71&action=53
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
        try{
            //open secret left menu
            new Actions(Driver.get()).moveToElement(localization).pause(100).click().perform();
            new Actions(Driver.get()).moveToElement(bankAccounts).pause(100).click().perform();
            new Actions(Driver.get()).moveToElement(leadsAndOpportunities).pause(100).click().perform();
            new Actions(Driver.get()).moveToElement(eCommerce).pause(100).click().perform();
            new Actions(Driver.get()).moveToElement(products).pause(100).click().perform();
        }catch (Exception ignored) {

        }

        try {
            BrowserUtils.waitForPresenceOfElement(By.partialLinkText(leftMenu), 5);
            BrowserUtils.waitForVisibility(By.partialLinkText(leftMenu), 5);
            Driver.get().findElement(By.partialLinkText(leftMenu)).click();
            waitUntilTitleToContain(leftMenu);
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.partialLinkText(leftMenu)), 5);
            waitUntilTitleToContain(leftMenu);
        }


    }

    //to navigate with only upperMenu
    public void navigateToModule(String upperMenu) {

        try {
            BrowserUtils.waitForClickablility(By.linkText(upperMenu), 5);
            WebElement tabElement = Driver.get().findElement(By.linkText(upperMenu));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
            waitUntilTitleToContain(upperMenu);
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(upperMenu), 5);
            waitUntilTitleToContain(upperMenu);
        }
    }

    //to navigate with only leftMenu
    public void navigateInLeftModule(String leftMenu) {

        try {
            BrowserUtils.waitForClickablility(By.linkText(leftMenu), 5);
            WebElement tabElement = Driver.get().findElement(By.linkText(leftMenu));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
            waitUntilTitleToContain(leftMenu);
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(leftMenu), 5);
            waitUntilTitleToContain(leftMenu);
        }
    }

    //to click common buttons
    public void clickButtonName(String buttonName){
        String xpath = "//button[contains(text(),'"+buttonName+"')]";
        WebElement button = Driver.get().findElement(By.xpath(xpath));
        new Actions(Driver.get()).moveToElement(button).pause(200).click().perform();
        BrowserUtils.waitFor(2);
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