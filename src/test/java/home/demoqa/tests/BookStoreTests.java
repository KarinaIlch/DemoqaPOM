package home.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookstore.LoginPage;
import home.demoqa.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//демо тег для того, щоб запустити тест з консолі/ вибірково ті,
// що позначені цим тегом

@Tag("demo")
public class BookStoreTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getBookStore(); // заходимо на HomePage (homepage - це клас)
        new SidePanel(driver).clickOnLogin(); // заходимо на SidePanel - login
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).enterData("neuer","Neuer1234!") // переходимо на login
                .clickOnLoginButton()
                .verifyUserName("neuer");
    }
}
