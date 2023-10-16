package pages.CauHoi;

import org.common.helpers.WebUI;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages.CauHoi.AddAnswer;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;

import java.util.ArrayList;
import java.util.List;

public class ManageQuestionPage {
    private WebDriver driver;
    private Actions actions;
    private WebUI webUI;

    public ManageQuestionPage(WebDriver driver) {
        actions = new Actions(driver);
        webUI = new WebUI(driver);
    }

    private String pageText = "Quản lí câu hỏi";
    private String url = "/question-management";
    private By headerPageText = By.xpath("//span[contains(text(),'Quản lí câu hỏi')]");
    private By addQuestion = By.xpath("//button[contains(text(),'Tạo mới')]");
    private By manualQuestion = By.xpath("//body/div[2]/div[2]/section[1]/div[2]/div[1]/div[1]/div[2]");

    private By searchInputElement = By.cssSelector("input[class='w-full h-full font-normal !bg-transparent outline-none placeholder:text-foreground-500 text-small']");
    private By titleChon = By.xpath("//button[contains(text(),'Chọn')]");
    private By buttonNext = By.xpath("//li[@aria-label='next page button']");

    //Xem lại đã add đúng chưa
    private By clickQuestion = By.xpath("//tbody/tr[1]");
    private By typeQuestion1 = By.cssSelector("label[for='type-0']");
    private By typeQuestion2 = By.cssSelector("label[for='type-1']");



    //Nhập tìm kiếm và kiểm tra kết quả tìm kiếm
    public void enterSearchQuestion(String searchText) {

        webUI.setText(searchInputElement, searchText);

//        actions.sendKeys(Keys.ENTER).build().perform();
        //Web không cần nhấn Enter
    }

    public void checkSearchTableByColumn(int column, String value) throws InterruptedException {

        //Xác định s dòng của table sau khi search
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng

        System.out.println("Số dòng tìm thấy " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            webUI.scrollUp(elementCheck);
            Thread.sleep(1000);

            //Ss giá trị truyền vào và kết quả thực tế
            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());

            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm");
            ;
        }

    }

    //Duyệt qua nhiều trang
    public void checkDataTableWithPagination(int pageTotal) throws InterruptedException {

        webUI.scrollUp(driver.findElement(titleChon));

        Thread.sleep(1000);

        for (int i = 1; i <= pageTotal; i++) {

            checkSearchTableByColumn(1, "Ứng xử");

            webUI.clickElement(buttonNext);

            Thread.sleep(500);

        }

        //Chỉ tìm đưc 11 element (bao gồm element không liên quan) - trên thực tế thì 17 page
//        // Tạo XPath để tìm phần tử của trang cuối cùng
//        By xpathForPage = By.xpath("//ul//li[contains(text(), 'page' )]");
//
//        // Tìm tất cả các phần tử trang
//        List<WebElement> tatCaCacPhanTuTrang = driver.findElements(xpathForPage);
//
//        // Lấy số trang cuối cùng
//        int soTrangCuoiCung = tatCaCacPhanTuTrang.size();

    }

    //Open form question
    public AddAnswer openFormQuestion() throws InterruptedException {

        webUI.scrollDown(driver.findElement(headerPageText));

        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        Thread.sleep(2000);

        Assert.assertTrue(webUI.verifyUrl(url), "Url sai --> Không phải trang Quản lý câu hỏi");

        Assert.assertTrue(webUI.verifyElementText(headerPageText, pageText), "Text sai --> Không phải trang quản lý câu hỏi");

        webUI.clickElement(addQuestion);
        webUI.clickElement(manualQuestion);

        return new AddAnswer(driver);
    }

    public WebDriver OpenFormQuestion() throws InterruptedException {

        webUI.scrollDown(driver.findElement(headerPageText));

        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        Thread.sleep(2000);

        Assert.assertTrue(webUI.verifyUrl(url), "Url sai --> Không phải trang Quản lý câu hỏi");

        Assert.assertTrue(webUI.verifyElementText(headerPageText, pageText), "Text sai --> Không phải trang quản lý câu hỏi");

        webUI.clickElement(addQuestion);
        webUI.clickElement(manualQuestion);

        return driver;
    }

}
