package pages.User;

import org.common.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CauHoi.AddAnswer;

import java.util.List;

public class QuanLyUserTho {
    private WebDriver driver;
    private WebUI webUI;

    public QuanLyUserTho(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    private String pageText = "Quản lý User thợ";
    private String url = "/worker-management";
    private By headerPageText = By.xpath("//span[contains(text(),'Quản lý User thợ')]");
    private By user = By.xpath("//body/aside[1]/div[2]/div[1]/button[1]");
    private By quanLyUserTho = By.xpath("//a[contains(text(),'Quản lí user thợ')]");
    private By searchInputUser = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains(url);
    }
    public boolean verifyElementText (){
        return driver.findElement(headerPageText).getText().equals(pageText);
    }

    public void openQuanLyUserTho() throws InterruptedException {

        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        Thread.sleep(2000);
        Assert.assertTrue(verifyUrl(), "Url sai --> Không phải trang Quản lý user thợ");

        Assert.assertTrue(verifyElementText(), "Text sai --> Không phải trang quản lý user thợ");
    }
    public void enterSearchQuestion(String searchText) {

        webUI.setText(searchInputUser, searchText);

//        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void checkSearchTableByColumn (int column, String value) {

        //Xác định s dòng của table sau khi search
        List<WebElement> row = driver.findElements(By.xpath("//tbody//tr"));
        int rowTotal = row.size(); //Lấy ra số dòng

        System.out.println("Số dòng tìm thấy " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            //Ss giá trị truyền vào và kết quả thực tế
            System.out.println(value + " - ");
            System.out.print(elementCheck.getText());

            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + "không chứa giá trị tìm kiếm");;
        }
    }
}




