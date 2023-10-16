package testcases;

import commons.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;

    @BeforeClass
    public void setup() {

        driver = getDriver();
    }

    @Test
    public void signInPage() throws InterruptedException {
        signInPage = new SignInPage(driver);
        signInPage.signIn("khanglv@vuatho.com","123456");

        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBroswer (){
        driver.quit();
    }
}
