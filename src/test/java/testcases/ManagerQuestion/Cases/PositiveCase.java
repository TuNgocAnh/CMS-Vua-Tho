package testcases.ManagerQuestion.Cases;

import pages.CauHoi.Modal.AnswerData;
import pages.CauHoi.Modal.InitalizeQuestionData;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PositiveCase {
    public static ArrayList<String> JobTitle = new ArrayList<String>(){
        {
            add("VUATHO-IT-DO - Lập trình DevOps");
        }
    };
    public static String QuestionContent = "ngocanh_test_1";
    public static String QuestionType = "Quy tắc ứng xử";
    public static String Time = "15";
    public static String Points = "20";


    public static ArrayList<AnswerData> AnswerDatas = new ArrayList<>(){
        {
            add(new AnswerData(true,"A", "answer_1"));
            add(new AnswerData(false,"B", "answer_2"));
        }
    };
    public static InitalizeQuestionData PositiveCaseData = new InitalizeQuestionData(
      JobTitle, QuestionContent, AnswerDatas, QuestionType, Time,Points
    );
}
