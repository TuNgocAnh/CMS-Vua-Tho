package pages.CauHoi.InitalizeQuestions;

import org.common.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CauHoi.Constances;
import pages.CauHoi.Modal.InitalizeQuestionData;

public class CreateQuestion {
    protected WebDriver Driver;
    protected Actions Action;
    protected org.common.helpers.WebUI WebUI;
    protected InitalizeQuestionData TestData;
    public CreateQuestion(WebDriver driver, InitalizeQuestionData testData) {
        Driver = driver;
        Action = new Actions(driver);
        WebUI = new WebUI(driver);
        TestData = testData;
    }

    public void InitTestCase(){
        InitJobTitle();
        InitQuestionType();
        InitQuestionContent();
        InitAnswer();
        InitTime();
        InitPoints();
    }
    private void InitJobTitle() {
        TestData.JobTitles.forEach(data -> {
            try {
                Driver.findElement(Constances.JobTitleElement).sendKeys(data);
                Thread.sleep(2000);
                Action.sendKeys(Keys.ENTER).build().perform();
            }catch (Exception e) {
                System.out.println("Can't select " + data);
            }
        });
    }

    private void InitQuestionType(){
        By e = By.xpath(String.format("//span[contains(text(),'%s')]", TestData.QuestionType));
        Driver.findElement(e).click();
    }

    private void InitQuestionContent(){
        Driver.findElement(Constances.QuestionContentElement).sendKeys(TestData.QuestionContent);

    }

    private void InitAnswer(){
//        TestData.AnswerDatas.forEach(answerData -> {
//            try {
//            Driver.findElement(Constances.answer1).sendKeys(answerData);
//                Thread.sleep(2000);
////            Driver.findElement(Constances.answer2).sendKeys(answerData);}
//            catch (Exception e) {
//                System.out.println("Can't select " + answerData);
//            }
//
//        });

        TestData.AnswerDatas.forEach(data -> {
            try {
                Driver.findElement(Constances.answer1).sendKeys(data);
                            Driver.findElement(Constances.answer2).sendKeys(data);
            }catch (Exception e) {
                System.out.println("Can't select " + data);
            }
        });
    }

    private void InitTime(){
        Driver.findElement(Constances.time).sendKeys(TestData.Time);

    }

    private void InitPoints(){
        Driver.findElement(Constances.point).sendKeys(TestData.Points);
    }

    public boolean ValidateJobTitle(){
        return true;
    }
}
