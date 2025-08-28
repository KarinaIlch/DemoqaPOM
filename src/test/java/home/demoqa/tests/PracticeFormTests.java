package home.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import home.demoqa.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition() {
        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).getForms();
        new SidePanel(driver).clickOnForms();
    }

    @Test
    public void createStudentAccountTest() {
        practiceForm.enterPersonalData("Nik", "Greyson", "nina@gm.com", "0987654321")
                .selectGender("Male")
                .typeOfData("1 Aug 2025")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobbies(new String[]{"Sports", "Reading"})
                .uploadFile("/Users/karinailchenko/Tools/9193_1.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }


//    @RepeatedTest(value = 3,failureThreshold = 2,name = "{displayName}{currentRepetition}/{totalRepetitions}")
    @Test
    public void createStudentAccountWithSelectDateTest() {
            practiceForm.enterPersonalData("Nik", "Greyson", "nina@gm.com", "0987654321")
                    .selectGender("Male")
                    .selectDate("August", "1987", "16")
                    .addSubjects(new String[]{"Math","Chemistry"})
                    .selectHobbies(new String[]{"Sports", "Reading"})
                    .uploadFile("/Applications/6552777201_w600_h600_6552777201.jpg.webp")
                    .inputState("NCR")
                    .inputCity("Delhi")
                    .submitForm()
                    .verifySuccessRegistration("Thanks for submitting the form");
        }
    }
