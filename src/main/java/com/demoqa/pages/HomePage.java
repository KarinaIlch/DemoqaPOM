package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(6)")
    WebElement bookstore;

    public SidePanel getBookStore() {
        clickWithJS(bookstore, 0,500);
        return new SidePanel(driver);

    }
    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        clickWithJS(alertsFrameWindows, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPages clickOnAlert(){
        click(alerts);
        return new AlertsPages(driver);
    }

    @FindBy(css = ".card:nth-child(4)")
    WebElement widgets;

    public SidePanel getWidgets() {
        clickWithJS(widgets, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(1)")
    WebElement elements;

    public SidePanel getElements() {
        clickWithJS(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(5)")
    WebElement interactions;

    public SidePanel getInteractions() {
        clickWithJS(interactions,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(2)")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJS(forms,0,300);
        return new SidePanel(driver);

    }
}

