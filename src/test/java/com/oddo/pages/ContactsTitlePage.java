package com.oddo.pages;

import com.oddo.utilities.BrowserUtils;
import com.oddo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsTitlePage extends BasePage {


    @FindBy(xpath = "(//*[contains(@data-menu-xmlid,'title')])[2]")
    public WebElement titleMenu;

    @FindBy(xpath = "(//*[@class='o_list_buttons']//button)[1]")
    public WebElement createTitle;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement titleBox;

    @FindBy(xpath = "//*[@name='shortcut']")
    public WebElement abbri;

    @FindBy(xpath = "(//*[@class='o_form_buttons_edit']//button)[1]")
    public WebElement save;

    @FindBy(xpath = "//*[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement saveMssg;

    @FindBy(xpath = "//*[@class='o_notification_title']")
    public WebElement popupMsg1;

    @FindBy(xpath ="//*[@class='o_notification_content']" )
    public WebElement popupMsg2;

    public void goTitle(String subMenu){
        BrowserUtils.waitForPageToLoad(3);
        Driver.get().findElement(By.xpath("(//*[contains(@data-menu-xmlid,'contacts')])[1]")).click();
    }



}
