package pages;

import commons.BaseSetup;
import org.common.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaiTest.ManageTestPage;
import pages.CauHoi.ManageQuestionPage;
import pages.User.QuanLyUserTho;

public class DashboardPage extends BaseSetup {
    private WebDriver driver;
    private WebUI webUI;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    private By test = By.xpath("//body/aside[1]/div[2]/div[1]/button[2]");
    private By managequestion = By.xpath("//a[contains(text(),'Quản lí câu hỏi')]");

    //Quản lý User Thợ
    private By user = By.cssSelector("body > aside:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
    private By quanLyUserTho = By.xpath("//a[contains(text(),'Quản lí user thợ')]");
    private By quanLyBaiTest = By.xpath("//a[contains(text(),'Quản lí bài test')]");




    public ManageQuestionPage openManageQuestion() throws InterruptedException {

        webUI.clickElement(test);
        webUI.clickElement(managequestion);

        Thread.sleep(1000);

        return new ManageQuestionPage(driver);
    }

    public QuanLyUserTho openQuanLyUserTho() throws InterruptedException {

        webUI.clickElement(user);
        webUI.clickElement(quanLyUserTho);

        Thread.sleep(1000);

        return new QuanLyUserTho(driver);
    }

    public ManageTestPage openQuanLyBaiTest() throws InterruptedException {

        webUI.clickElement(test);
        webUI.clickElement(quanLyBaiTest);

        Thread.sleep(1000);

        return new ManageTestPage(driver);
    }
}
