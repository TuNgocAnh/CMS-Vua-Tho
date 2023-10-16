package pages.CauHoi.Modal;

public class AnswerData {
    public boolean IsCorrected;
    public String TagName;
    public String Content;

    public AnswerData(boolean isCorrected, String tagName, String content) {
        IsCorrected = isCorrected;
        TagName = tagName;
        Content = content;
    }
}
