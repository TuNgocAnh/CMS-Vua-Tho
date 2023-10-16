package testcases;

import commons.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.SignInPage;
import pages.User.QuanLyUserTho;

public class QuanLyUserThoTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private QuanLyUserTho quanLyUserTho;

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
    public void openQuanLyUserTho() throws InterruptedException {
        quanLyUserTho = dashboardPage.openQuanLyUserTho();
        Thread.sleep(1000);
    }
}
