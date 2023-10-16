package testcases.ManagerQuestion;

import commons.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CauHoi.AddAnswer;
import pages.CauHoi.InitalizeQuestions.CreateQuestion;
import pages.DashboardPage;
import pages.CauHoi.ManageQuestionPage;
import pages.SignInPage;
import testcases.ManagerQuestion.Cases.PositiveCase;

public class ManagerQuestionTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private AddAnswer addAnswer;
    private ManageQuestionPage manageQuestionPage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void signInPage() throws InterruptedException {
        signInPage = new SignInPage(driver);

        dashboardPage = signInPage.signIn("khanglv@vuatho.com", "123456");

        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void openManagerQuestion() throws InterruptedException {
//        dashboardPage = new DashboardPage(driver);
        manageQuestionPage = dashboardPage.openManageQuestion();

        Thread.sleep(1000);
    }

//    @Test(priority = 3)
//    public void searchQuestion () throws InterruptedException {
//
//        manageQuestionPage.enterSearchQuestion("ứng xử");
//        Thread.sleep(2000);
//
//        manageQuestionPage.checkDataTableWithPagination(3);
//
//    }


    @Test(priority = 4)
    public void openFormQuestion() throws InterruptedException {
//        addAnswer = manageQuestionPage.openFormQuestion();
        driver = manageQuestionPage.OpenFormQuestion();

    }

    @Test(priority = 5)
    public void InitalQuestions() throws InterruptedException {
//        addAnswer.createBehaviorQuestion("VUATHO", "Lập trình", "1", "3", "15", "3");
        CreateQuestion Engine = new CreateQuestion(driver, PositiveCase.PositiveCaseData);
        Engine.InitTestCase();
//       Validator.ValidateJobTitle();

//        manageQuestionPage = addAnswer.testContentQuestion();
    }
    public void closeBrowser() {
        driver.close();
    }
}
