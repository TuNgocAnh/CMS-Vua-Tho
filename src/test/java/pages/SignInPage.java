package pages;

import org.common.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    private WebDriver driver;
    private WebUI webUI;
    public SignInPage (WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(this.driver);
    }

    private By emailInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]");
    private By passwordInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/input[1]");
    private By signInBtn = By.xpath("//button[contains(text(),'Đăng nhập')]");
    private String url = "https://cms-vuatho-clone.vercel.app/";
    private String pageText = "Trang chủ";
//    private By headerPageText = By.xpath("//span[contains(text(),'Trang chủ')]");

    public DashboardPage signIn (String emailValue, String passwordValue) {

        Assert.assertTrue(webUI.verifyUrl(url),"Không phải trang chủ");
//        Assert.assertTrue(webUI.verifyElementText(headerPageText, pageText), "Không phải trang chủ");

        webUI.setText(emailInput, emailValue);
        webUI.setText(passwordInput,passwordValue);
        webUI.clickElement(signInBtn);

        return new DashboardPage(driver);
    }

}
