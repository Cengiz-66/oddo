package com.oddo.pages;

import com.oddo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectorsOfActivity extends BasePage{

    @FindBy(css = ".o_pager_limit")
    public WebElement numberOfSectors;

    @FindBy(xpath = "//table[@*='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//span[contains(text(),'Sectors of Activity')]")
    public WebElement sectorsOfActivity;

    @FindBy(xpath = "(//input[@*='checkbox'])[24]")
    public WebElement checkBox;

    @FindBy(xpath = "(//button[@*='dropdown'])[2]")
    public WebElement actionMenu;

    public WebElement getActionMenu(String option){
        return Driver.get().findElement(By.xpath("//a[contains(text(),'"+option+"')]"));
    }

    @FindBy(xpath = "//h4")
    public WebElement actualErrorMessage;
}
