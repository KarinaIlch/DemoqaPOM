package home.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPages;
import com.demoqa.pages.alertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.alertsFrameWindows.IframePage;
import com.demoqa.pages.alertsFrameWindows.NestedIframePage;
import home.demoqa.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPages alerts;
    IframePage iframe;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPages(driver);
        iframe = new IframePage(driver);
        new HomePage(driver).getAlertsFrameWindows();
    }

    @Test
    @DisplayName("Verify to - Alert appears after 5 second waiting") // опис назви теста
    public void waitAlertTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnSecondButton()
                .verifyAlertWithTimer();
    }

    @Test
    public void selectResultTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnTheThirdButton()
                .selectResult("Cansel")
                .verifyResult("Cansel");
    }

    @Test
    public void sendMessageToAlertTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnFourthButton()
                .sendMessageToAlert("Hello, world!")
                .verifyMessage("Hello, world!");

    }

    @Test
    public void newTabTest() {
        sidePanel.clickOnBrowserWindows();
        new BrowserWindowsPage(driver).clickOnNewTabButton()
                .newTabHandle(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewIframeByIndexTest() {
        sidePanel.clickOnFrame();
        iframe.returnListOfFrames()
        .switchToIframeByIndex(1)
        .verifyByTitle("This is a sample page");

    }

    @Test
    public void switchToNewIframeByIdTest(){
        sidePanel.clickOnFrame();
        iframe.switchToIframeByID()
            .verifyByTitle("This is a sample page")
            .switchToMainPage()
            .verifyMainPageTitle("Frames");

}
    @Test
    public void nestedIframesTest(){
        sidePanel.clickOnNestedFrames();
        new NestedIframePage(driver)
                .verifyNestedIframes();

    }
}
