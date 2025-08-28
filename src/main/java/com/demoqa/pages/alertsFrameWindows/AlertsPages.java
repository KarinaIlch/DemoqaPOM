package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPages extends BasePage {

    public AlertsPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPages clickOnSecondButton() {
        clickWithJS(timerAlertButton, 0, 200);
        return this;
    }

    public AlertsPages verifyAlertWithTimer() {
        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPages clickOnTheThirdButton() {
        clickWithJS(confirmButton, 0, 300);
        return this;
    }

    public AlertsPages selectResult(String result) {

        if (result != null && result.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cansel")) {
            driver.switchTo().alert().dismiss();

        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPages verifyResult(String text) {
        Assertions.assertTrue(containsText(text, confirmResult));
        return this;
    }


    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPages clickOnFourthButton() {
        clickWithJS(promtButton, 0, 400);
        return this;
    }

    public AlertsPages sendMessageToAlert(String message) {
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPages verifyMessage(String message) {
        Assertions.assertTrue(containsText(message,promptResult));
        return this;
    }

}
