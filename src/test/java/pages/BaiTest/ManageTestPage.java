package pages.BaiTest;

import org.common.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.CauHoi.AddAnswer;

public class ManageTestPage {
    private WebDriver driver;
    private Actions actions;
    private WebUI webUI;

    public ManageTestPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
        webUI = new WebUI(driver);
    }

    private String pageText = "Quản lí bài test";
    private String url = "/test-management";
    private By headerPageText = By.xpath("//span[contains(text(),'Quản lí bài test')]");
    private By taoMoi = By.xpath("//button[contains(text(),'Tạo mới')]");
    private By searchInputElement = By.cssSelector("input[class='w-full h-full font-normal !bg-transparent outline-none placeholder:text-foreground-500 text-small']");
    private By titleChon = By.xpath("//button[contains(text(),'Chọn')]");
    private By buttonNext = By.xpath("//li[@aria-label='next page button']");

    public AddTest openFormQuanLyBaiTest() throws InterruptedException {

        webUI.scrollDown(driver.findElement(headerPageText));

        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        Thread.sleep(2000);

        Assert.assertTrue(webUI.verifyUrl(url), "Url sai --> Không phải trang Quản lý bài test");

        Assert.assertTrue(webUI.verifyElementText(headerPageText, pageText), "Text sai --> Không phải trang quản lý câu hỏi");

        webUI.clickElement(taoMoi);

        return new AddTest (driver);
    }
}
