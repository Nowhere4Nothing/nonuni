package Headfirst.FlashCards;
import java.io.*;
import java.util.Arrays;

public class QuizCard implements Serializable {
    private final String q;
    private final String a;

    QuizCard (String question, String answer) {
        this.q = question;
        this.a = answer;
    }

    public String getQuestion() {
        return q;
    }

    public String getAnswer() {
        return a;
    }
}
