package home.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.MenuPage;
import home.demoqa.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).clickOnMenu();
    }

    @Test
    public void hoverMouseOnMenuTest() {
        new MenuPage(driver).hoverMouseOnSubMenu()
                .verifySubMenu();
    }
}
