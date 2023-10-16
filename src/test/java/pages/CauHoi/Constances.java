package pages.CauHoi;

import org.openqa.selenium.By;

public class Constances {
    static String pageTextForm = "Tạo mới câu hỏi";
    static String QuestionManagermentPageURL = "/question-management/form";

    static By headerPageTextForm = By.xpath("//h5[contains(text(),'Tạo mới câu hỏi')]");
    public static By JobTitleElement = By.xpath("//div[@class='border-[#e4e4e7] border-2 rounded-lg css-b62m3t-container']//input[@id='react-select-2-input']\n");
    public static By questionType1 = By.xpath("//span[contains(text(),'Quy tắc ứng xử')]");
    static By questionType2 = By.xpath("//span[contains(text(),'Nghiệp vụ')]");
    public static By QuestionContentElement = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");

    //Đính kèm Video/Hình ảnh/PDF (Chưa làm)

    public static By answer1 = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");
    public static By answer2 = By.cssSelector("body > div:nth-child(2) > main:nth-child(2) > form:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)");
    static By choiceAnswer1 = By.xpath("//body/div[1]/main[1]/form[1]/div[1]/div[4]/div[2]/div[1]/label[1]");
    static By choiceAnswer2 = By.xpath("//body/div[1]/main[1]/form[1]/div[1]/div[4]/div[2]/div[2]/label[1]");
    public static By time = By.xpath("//div[@class='inline-flex h-full items-center w-full gap-1.5 box-border']/input[@aria-label='Nhập số giây']\n");
    public static By point = By.xpath("//div[@class='inline-flex h-full items-center w-full gap-1.5 box-border']/input[@aria-label='Nhập số điểm']\n");
    static By btnConfirm = By.xpath("//button[contains(text(),'Xác nhận')]");

    //Kiểm tra lại thông tin câu hỏi
    static By clickQuestion = By.xpath("//tr[@data-first='true']");
    static By typeQuestion1 = By.xpath("//body[1]/div[2]/div[2]/section[1]/div[2]/form[1]/div[2]/div[1]/div[1]/label[1]");
    static By typeQuestion2 = By.xpath("//label[@for='type-1']//span[contains(text(),'Nghiệp vụ')]");

}
