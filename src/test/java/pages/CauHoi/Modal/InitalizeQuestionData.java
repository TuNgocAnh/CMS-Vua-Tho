package pages.CauHoi.Modal;

import java.util.ArrayList;
import java.util.List;

public class InitalizeQuestionData {
    public ArrayList<String> JobTitles;
    public String QuestionContent;
    public ArrayList<AnswerData> AnswerDatas;
    public String QuestionType;
    public String Time;
    public String Points;


    public InitalizeQuestionData(
            ArrayList<String> jobTitles,
            String questionContent,
            ArrayList<AnswerData> answerDatas,
            String questionType,
            String time,
            String points
    ) {
        JobTitles = jobTitles;
        QuestionContent = questionContent;
        AnswerDatas = answerDatas;
        QuestionType = questionType;
        Time = time;
        Points = points;
    }

}
