package pages.CauHoi;

import org.common.helpers.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class AddAnswer {
    private WebDriver driver;
    private Actions action;
    private WebUI webUI;

    public AddAnswer(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        webUI = new WebUI(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Element at ManageQuestionPage
    public boolean verifyUrl() {
        return driver.getCurrentUrl().contains(Constances.QuestionManagermentPageURL);
    }

    public boolean verifyElementText() {
        return driver.findElement(Constances.headerPageTextForm).getText().equals(Constances.pageTextForm);
    }

    public void createBehaviorQuestion(String jobValue, String questionContentValue, String answer1Value, String answer2Value, String timeValue, String pointValue) throws InterruptedException {

        System.out.println(driver.getCurrentUrl());
        System.out.println(Constances.QuestionManagermentPageURL);
        Thread.sleep(2000);
        assertTrue(verifyUrl(), "Url sai --> Không phải trang Tạo mới câu hỏi");

        assertTrue(verifyElementText(), "Text sai --> Không phải trang Tạo mới câu hỏi");
        Thread.sleep(1000);

        driver.findElement(Constances.JobTitleElement).sendKeys(jobValue);

        Thread.sleep(5000);

        action.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(Constances.questionType1).click();
        driver.findElement(Constances.QuestionContentElement).sendKeys(questionContentValue);
        driver.findElement(Constances.answer1).sendKeys(answer1Value);
        driver.findElement(Constances.answer2).sendKeys(answer2Value);
        Thread.sleep(1000);
        webUI.scrollUp(driver.findElement(Constances.QuestionContentElement));

//        action.moveToElement(driver.findElement(choiceAnswer1)).click().build().perform();
        webUI.scrollUp(driver.findElement(Constances.QuestionContentElement));
        driver.findElement(Constances.choiceAnswer1).click();
        Thread.sleep(1000);
        driver.findElement(Constances.time).sendKeys(timeValue);
        driver.findElement(Constances.point).sendKeys(pointValue);

        webUI.clickElement(Constances.btnConfirm);

    }

    public ManageQuestionPage testContentQuestion () {

        webUI.clickElement(Constances.clickQuestion);

        try {

            String text1 = driver.findElement(Constances.questionType1).getText();
            String text2 = driver.findElement(Constances.typeQuestion1).getText();

            // So sánh giá trị và sử dụng assertTrue để kiểm tra
            Assert.assertTrue(text1.equals(text2), "Sai rồi. Giá trị của phần tử thứ nhất: " + text1 + ". Giá trị của phần tử thứ hai: " + text2);
        } catch (Exception e) {
            // Nếu có lỗi, in ra thông báo
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
        return new ManageQuestionPage(driver);

    }

}
