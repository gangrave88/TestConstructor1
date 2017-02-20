package com.gangrave88.testconstructor1.realmModel;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Question extends RealmObject{

    @PrimaryKey
    private int id;

    private String name;
    private Answer correctAnswer;
    private Answer currentAnswer;
    private RealmList<Answer> answers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Answer getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(Answer currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public RealmList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(RealmList<Answer> answers) {
        this.answers = answers;
    }

    public boolean isAnswerCorrect(Answer userAnswer){
        return correctAnswer.equals(userAnswer);
    }
}
