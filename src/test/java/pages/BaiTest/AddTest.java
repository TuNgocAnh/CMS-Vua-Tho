package pages.BaiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddTest {
    private WebDriver driver;
    public AddTest
            (WebDriver driver) {
        this.driver = driver;
    }

    private String pageTextForm = "Tạo mới bài test";
    private String url = "/test-management/form";

    private By headerPageTextForm = By.xpath("//h5[contains(text(),'Tạo mới câu hỏi')]");
    private By search = By.xpath("//body/div[1]/main[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");
    private By testQuyTacUngXu = By.xpath("//span[contains(text(),'Quy tắc ứng xử')]");
    private By testNghiepVu = By.xpath("//span[contains(text(),'Nghiệp vụ')]");
    private By tenBaiTest = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");
    private By moTaBaiTest = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");
    private By huongDanBaiTest = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");








}
